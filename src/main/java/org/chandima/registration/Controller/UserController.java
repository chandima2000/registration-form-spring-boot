package org.chandima.registration.Controller;

import org.chandima.registration.DTO.UserDTO;
import org.chandima.registration.Entity.User;
import org.chandima.registration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public UserDTO signUp(@ModelAttribute User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setMobileNo(user.getMobileNo());
        System.out.println("Successfully Registered");
        return userService.saveUser(userDTO);
    }

    @PostMapping("/login")
    public UserDTO logIn(@RequestBody Map<String, String> loginRequest){
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        UserDTO userDTO = userService.getUser(email, password);
        if (userDTO != null){
            System.out.println("Successfully logged in");
            return userDTO;
        }else {
            System.out.println("Login failed");
            return null;
        }
    }

}
