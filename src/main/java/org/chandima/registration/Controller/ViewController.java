package org.chandima.registration.Controller;

import org.chandima.registration.Entity.User;
import org.chandima.registration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @Autowired
    private UserService userService;
    @GetMapping("/signup")
    public String getSignupForm(Model model) {
        model.addAttribute("registerRequest", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user) {
        // Process signup logic here
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        boolean isAuthenticated = userService.authenticate(user.getEmail(), user.getPassword());
        if (isAuthenticated) {
            model.addAttribute("success", "Login successful!");
            return "redirect:/dashboard?success=Login+successful!";
        } else {
            return "redirect:/login?error";
        }
    }
}
