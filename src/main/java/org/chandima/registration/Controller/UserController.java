package org.chandima.registration.Controller;

import org.chandima.registration.DTO.LoginDTO;
import org.chandima.registration.DTO.UserDTO;
import org.chandima.registration.Entity.User;
import org.chandima.registration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return userService.saveUser(userDTO);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        System.out.println("Login attempt for email: " + loginDTO.getEmail());
        try {
            UserDTO userDTO = userService.login(loginDTO.getEmail(), loginDTO.getPassword());
            if (userDTO != null) {
                System.out.println("Login successful for email: " + loginDTO.getEmail());
                return ResponseEntity.ok(userDTO);
            } else {
                System.out.println("Invalid email or password for email: " + loginDTO.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during login: " + e.getMessage());
        }
    }
}
