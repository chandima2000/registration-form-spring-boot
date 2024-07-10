package org.chandima.registration.Controller;

import org.chandima.registration.DTO.UserDTO;
import org.chandima.registration.Entity.User;
import org.chandima.registration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ViewController {

    private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String getSignupForm(Model model) {
        model.addAttribute("registerRequest", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user, Model model) {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            userDTO.setMobileNo(user.getMobileNo());

            UserDTO savedUser = userService.saveUser(userDTO);
            if (savedUser == null) {
                model.addAttribute("error", "Email is already registered");
                return "signup";
            }

            return "redirect:/login";
        } catch (Exception e) {
            logger.error("Error during signup: ", e);
            model.addAttribute("error", "An unexpected error occurred during signup");
            return "signup";
        }
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        try {
            boolean isAuthenticated = userService.authenticate(user.getEmail(), user.getPassword());
            if (isAuthenticated) {
                return "redirect:/dashboard?success=Login successful";
            } else {
                model.addAttribute("error", "Invalid email or password");
                return "login";
            }
        } catch (Exception e) {
            logger.error("Error during login: ", e);
            model.addAttribute("error", "An unexpected error occurred during login");
            return "login";
        }
    }
}
