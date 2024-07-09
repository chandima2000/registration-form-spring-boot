package org.chandima.registration.Service;

import org.chandima.registration.DTO.UserDTO;
import org.chandima.registration.Entity.User;
import org.chandima.registration.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {



    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;
    public UserDTO saveUser(UserDTO userDTO){
        userRepository.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    public UserDTO login(String email, String password) {
        System.out.println("UserService login attempt for email: " + email);
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setMobileNo(user.getMobileNo());
            return userDTO;
        }
        return null;
    }

}
