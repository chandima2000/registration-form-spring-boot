package org.chandima.registration.Controller;

import org.chandima.registration.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/signup")
    public String getSignupForm(Model model) {
        model.addAttribute("registerRequest", new User());
        return "signup";
    }
}
