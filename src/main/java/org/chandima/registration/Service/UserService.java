package org.chandima.registration.Service;

import org.chandima.registration.DTO.UserDTO;
import org.chandima.registration.Entity.User;
import org.chandima.registration.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;
    public UserDTO saveUser(UserDTO userDTO){
        userRepository.save(modelMapper.map(userDTO, User.class));
        System.out.println("Registration Successful");
        return userDTO;
    }

    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    public UserDTO getUser(String email, String password){
        User user = userRepository.findByEmail(email);
        if (user != null){
            if (Objects.equals(user.getPassword(), password)){
                return modelMapper.map(user, UserDTO.class);
            }else {
                System.out.println("Invalid Password");
                return null;
            }
        }else {
            System.out.println("Invalid email");
            return null;
        }
    }

}
