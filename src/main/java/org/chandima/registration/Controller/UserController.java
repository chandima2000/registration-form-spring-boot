package org.chandima.registration.Controller;

import org.chandima.registration.DTO.UserDTO;
import org.chandima.registration.Entity.User;
import org.chandima.registration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public Map<String, String> signUp(@ModelAttribute User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setMobileNo(user.getMobileNo());

        UserDTO savedUser = userService.saveUser(userDTO);
        if (savedUser == null) {
            return Map.of("status", "error", "message", "Email is already registered");
        }
        return Map.of("status", "success", "message", "Successfully registered");
    }

    @PostMapping("/login")
    public Map<String, String> logIn(@RequestBody Map<String, String> loginRequest){
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        UserDTO userDTO = userService.getUser(email, password);
        if (userDTO != null){
            return Map.of("status", "success", "message", "Successfully logged in");
        }else {
            return Map.of("status", "error", "message", "Login failed");
        }
    }
}
