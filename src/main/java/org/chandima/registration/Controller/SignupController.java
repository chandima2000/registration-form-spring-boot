package org.chandima.registration.Controller;

import jakarta.validation.Valid;
import org.chandima.registration.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SignupController {
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";  // This should match the name of your Thymeleaf template file (signup.html)
    }

    @PostMapping("/signup")
    public String processSignup(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";  // If validation errors are found, return to signup form
        }

        // Save user to the database or perform any other processing
        // This is where you would typically call a service to save the user details

        return "redirect:/success";  // Redirect to a success page after successful registration
    }
}
