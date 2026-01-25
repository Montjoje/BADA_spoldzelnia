package com.mikolaj.spoldzielnia_bada_projekt;


import com.mikolaj.spoldzielnia_bada_projekt.DAO.*;
import com.mikolaj.spoldzielnia_bada_projekt.tables.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.security.Principal;
import java.util.List;

@Controller
public class AppController implements WebMvcConfigurer {

    private final SpoldzielnieMieszkanioweDAO spoldzielnieMieszkanioweDAO;
    private final BudynkiDAO budynkiDAO;
    private final KlatkiDAO klatkiDAO;
    private final LokaleDAO lokaleDAO;
    private final AdresyEmailDAO adresyEmailDAO;
    private final MieszkancyDAO mieszkancyDAO;
    private final MieszkancyService mieszkancyService;
    private final UserProfileDAO userProfileDAO;

    public AppController(SpoldzielnieMieszkanioweDAO spoldzielnieMieszkanioweDAO, BudynkiDAO budynkiDAO, KlatkiDAO klatkiDAO, LokaleDAO lokaleDAO, AdresyEmailDAO adresyEmailDAO, MieszkancyDAO mieszkancyDAO, MieszkancyService mieszkancyService, UserProfileDAO userProfileDAO) {
        this.spoldzielnieMieszkanioweDAO = spoldzielnieMieszkanioweDAO;
        this.budynkiDAO = budynkiDAO;
        this.klatkiDAO = klatkiDAO;
        this.lokaleDAO = lokaleDAO;
        this.adresyEmailDAO = adresyEmailDAO;
        this.mieszkancyDAO = mieszkancyDAO;
        this.mieszkancyService = mieszkancyService;
        this.userProfileDAO = userProfileDAO;
    }




    @RequestMapping(value = {"/admin/admin_main"})
    public String viewAdminPage() {
        return "admin/admin_main";
    }
    @RequestMapping(value = {"/user/user_main"})
    public String viewUserPage(Model model, Principal principal) {
        String username = principal.getName();
        int nrMieszkanca = Integer.parseInt(
                username.substring(username.indexOf("@") + 1)
        );
        UserProfileDTO profile = userProfileDAO.getProfile(nrMieszkanca);
        model.addAttribute("profile", profile);
        return "user/user_main";
    }
    @PostMapping("/user/update-contact")
    public String updateContactData(
            @RequestParam String numerKontaktowy,
            @RequestParam String adresEmail,
            Principal principal
    ) {
        int nrMieszkanca = Integer.parseInt(
                principal.getName().substring(principal.getName().indexOf("@") + 1)
        );

        userProfileDAO.updatePhoneAndEmail(
                nrMieszkanca,
                numerKontaktowy,
                adresEmail
        );

        return "redirect:/user/user_main";
    }

    @RequestMapping(value = {"/admin/spoldzielnie"})
    public String viewSpoldzielniePage(Model model) {
        List<SpoldzielnieMieszkaniowe> spoldzielnieMieszkanioweList = spoldzielnieMieszkanioweDAO.list();
        model.addAttribute("spoldzielnieMieszkanioweList", spoldzielnieMieszkanioweList);
        SpoldzielnieMieszkaniowe spoldzielnieMieszkaniowe = new SpoldzielnieMieszkaniowe();
        model.addAttribute("spoldzielnieMieszkaniowe", spoldzielnieMieszkaniowe);
        return "admin/spoldzielnie";
    }
    @RequestMapping(value = "/admin/spoldzielnie/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("spoldzielnieMieszkaniowe") SpoldzielnieMieszkaniowe spoldzielnieMieszkaniowe) {
        spoldzielnieMieszkanioweDAO.save(spoldzielnieMieszkaniowe);
        return "redirect:/admin/spoldzielnie";
    }
    @RequestMapping(value = "/admin/spoldzielnie/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("spoldzielnieMieszkaniowe") SpoldzielnieMieszkaniowe spoldzielnieMieszkaniowe) {
        spoldzielnieMieszkanioweDAO.update(spoldzielnieMieszkaniowe);
        return "redirect:/admin/spoldzielnie";
    }
    @RequestMapping("/admin/spoldzielnie/delete/{nrSpoldzielni}")
    public String delete(@PathVariable int nrSpoldzielni) {
        spoldzielnieMieszkanioweDAO.delete(nrSpoldzielni);
        return "redirect:/admin/spoldzielnie";
    }
    @RequestMapping(value = {"/admin/budynki"})
    public String viewBudynkiPage(Model model) {
        List<Budynki> budynkiList = budynkiDAO.list();
        model.addAttribute("budynkiList", budynkiList);
        Budynki budynki = new Budynki();
        model.addAttribute("budynki", budynki);
        return "admin/budynki";
    }
    @RequestMapping(value = "/admin/budynki/saveBudynki", method = RequestMethod.POST)
    public String saveBudynki(@ModelAttribute("budynki") Budynki budynki) {
        budynkiDAO.save(budynki);
        return "redirect:/admin/budynki";
    }
    @RequestMapping(value = "/admin/budynki/updateBudynki", method = RequestMethod.POST)
    public String updateBudynki(@ModelAttribute("budynki")  Budynki budynki) {
        budynkiDAO.update(budynki);
        return "redirect:/admin/budynki";
    }
    @RequestMapping("/admin/budynki/deleteBudynki/{nrBudynku}")
    public String deleteBudynki(@PathVariable int nrBudynku) {
        budynkiDAO.delete(nrBudynku);
        return "redirect:/admin/budynki";
    }
    @RequestMapping(value = {"/admin/klatki"})
    public String viewKlatkiPage(Model model) {
        List<Klatki> klatkiList = klatkiDAO.list();
        model.addAttribute("klatkiList", klatkiList);
        Klatki klatki = new Klatki();
        model.addAttribute("klatki", klatki);
        return "admin/klatki";
    }
    @RequestMapping(value = "/admin/klatki/saveKlatki", method = RequestMethod.POST)
    public String saveKlatki(@ModelAttribute("klatki") Klatki klatki) {
        klatkiDAO.save(klatki);
        return "redirect:/admin/klatki";
    }
    @RequestMapping(value = "/admin/klatki/updateKlatki", method = RequestMethod.POST)
    public String updateKlatki(@ModelAttribute("klatki")  Klatki klatki) {
        klatkiDAO.update(klatki);
        return "redirect:/admin/klatki";
    }
    @RequestMapping("/admin/klatki/deleteKlatki/{nrKlatki}")
    public String deleteKlatki(@PathVariable int nrKlatki) {
        klatkiDAO.delete(nrKlatki);
        return "redirect:/admin/klatki";
    }
    @RequestMapping(value = {"/admin/lokale"})
    public String viewLokalePage(Model model) {
        List<Lokale> lokaleList = lokaleDAO.list();
        model.addAttribute("lokaleList", lokaleList);
        Lokale lokale = new Lokale();
        model.addAttribute("lokale", lokale);
        return "admin/lokale";
    }
    @RequestMapping(value = "/admin/lokale/saveLokale", method = RequestMethod.POST)
    public String saveLokale(@ModelAttribute("lokale") Lokale lokale) {
        lokaleDAO.save(lokale);
        return "redirect:/admin/lokale";
    }
    @RequestMapping(value = "/admin/lokale/updateLokale", method = RequestMethod.POST)
    public String updateLokale(@ModelAttribute("lokale")  Lokale lokale) {
        lokaleDAO.update(lokale);
        return "redirect:/admin/lokale";
    }
    @RequestMapping("/admin/lokale/deleteLokale/{nrLokalu}")
    public String deleteLokale(@PathVariable int nrLokalu) {
        lokaleDAO.delete(nrLokalu);
        return "redirect:/admin/lokale";
    }
    @RequestMapping(value = {"/admin/adresyEmail"})
    public String viewAdresyEmailPage(Model model) {
        List<AdresyEmail> adresyEmailList = adresyEmailDAO.list();
        model.addAttribute("adresyEmailList", adresyEmailList);
        AdresyEmail adresyEmail = new AdresyEmail();
        model.addAttribute("adresyEmail", adresyEmail);
        return "admin/adresy_email";
    }

    @RequestMapping(value = "/admin/adresyEmail/saveAdresyEmail", method = RequestMethod.POST)
    public String saveAdresyEmail(@ModelAttribute("adresyEmail") AdresyEmail adresyEmail) {
        adresyEmailDAO.save(adresyEmail);
        return "redirect:/admin/adresyEmail";
    }

    @RequestMapping(value = "/admin/adresyEmail/updateAdresyEmail", method = RequestMethod.POST)
    public String updateAdresyEmail(@ModelAttribute("adresyEmail") AdresyEmail adresyEmail) {
        adresyEmailDAO.update(adresyEmail);
        return "redirect:/admin/adresyEmail";
    }

    @RequestMapping("/admin/adresyEmail/deleteAdresyEmail/{nrAdrEmail}")
    public String deleteAdresyEmail(@PathVariable Integer nrAdrEmail) {
        adresyEmailDAO.delete(nrAdrEmail);
        return "redirect:/admin/adresyEmail";
    }
    @RequestMapping(value = {"/admin/mieszkancy"})
    public String viewMieszkancyPage(Model model) {
        List<Mieszkancy> mieszkancyList = mieszkancyDAO.list();
        model.addAttribute("mieszkancyList", mieszkancyList);

        Mieszkancy mieszkancy = new Mieszkancy();
        model.addAttribute("mieszkancy", mieszkancy);

        return "admin/mieszkancy";
    }

    @RequestMapping(value = "/admin/mieszkancy/saveMieszkancy", method = RequestMethod.POST)
    public String saveMieszkancy(@ModelAttribute("mieszkancy") Mieszkancy mieszkancy) {
        mieszkancyService.save(mieszkancy);
        return "redirect:/admin/mieszkancy";
    }

    @RequestMapping(value = "/admin/mieszkancy/updateMieszkancy", method = RequestMethod.POST)
    public String updateMieszkancy(@ModelAttribute("mieszkancy") Mieszkancy mieszkancy) {
        mieszkancyDAO.update(mieszkancy);
        mieszkancyService.updatePassword(mieszkancy.getNrMieszkanca(), mieszkancy.getPassword());
        return "redirect:/admin/mieszkancy";
    }

    @RequestMapping("/admin/mieszkancy/deleteMieszkancy/{nrMieszkanca}")
    public String deleteMieszkancy(@PathVariable int nrMieszkanca) {
        mieszkancyDAO.delete(nrMieszkanca);
        return "redirect:/admin/mieszkancy";
    }



    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/admin").setViewName("admin/admin_main");
        registry.addViewController("/admin/admin_main").setViewName("admin/admin_main");
        registry.addViewController("/perspectives").setViewName("perspectives");
        registry.addViewController("/user").setViewName("user/user_main");
        registry.addViewController("/user/user_main").setViewName("user/user_main");
        registry.addViewController("/admin/spoldzielnie").setViewName("admin/spoldzielnie");
        registry.addViewController("/admin/budynki").setViewName("admin/budynki");
        registry.addViewController("/admin/klatki").setViewName("admin/klatki");
        registry.addViewController("/admin/lokale").setViewName("admin/lokale");
        registry.addViewController("/admin/adresyEmail").setViewName("admin/adresy_email");
        registry.addViewController("/admin/mieszkancy").setViewName("admin/mieszkancy");

    }

    @Controller
    public static class DashboardController {
        @RequestMapping("/perspectives")
        public String defaultSuccessUrl(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/admin/admin_main";
            } else if (request.isUserInRole("USER")) {
                return "redirect:/user/user_main";
            } else {
            }
            return "redirect:/index";
        }
    }
}
