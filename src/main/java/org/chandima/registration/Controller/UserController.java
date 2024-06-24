package org.chandima.registration.Controller;

import org.chandima.registration.Entity.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String home(){
        return "signup";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserDetails u){
        System.out.println(u);
        return "redirect:/";
    }
}
