package com.ordtilord.mvc.controllers;

import com.ordtilord.mvc.models.BrugerEntity;
import com.ordtilord.mvc.services.BrugerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final BrugerService brugerService;

    @Autowired
    public AuthController(BrugerService brugerService) {
        this.brugerService = brugerService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        model.addAttribute("bruger", new BrugerEntity());
        return "register";
    }

    @PostMapping("/register/save")
    public String register(@ModelAttribute("bruger") BrugerEntity bruger,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bruger", bruger);
            return "register";
        }

        // Tjek om navnet eller e-mailen allerede findes
        if (brugerService.existsByNavn(bruger.getNavn())) {
            model.addAttribute("navnExists", "Navnet er allerede taget");
            return "register";
        }

        if (brugerService.existsByEmail(bruger.getEmail())) {
            model.addAttribute("emailExists", "Email er allerede i brug");
            return "register";
        }

        // Gem brugeren i databasen
        brugerService.createBruger(bruger);
        return "redirect:/login?success";
    }
}



