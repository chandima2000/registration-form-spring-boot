package org.chandima.registration.Service;

import org.chandima.registration.DTO.UserDTO;
import org.chandima.registration.Entity.User;
import org.chandima.registration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public UserDTO saveUser(UserDTO userDTO) {
        try {
            User existingUser = userRepository.findByEmail(userDTO.getEmail());
            if (existingUser != null) {
                return null; // Email already registered
            }

            User user = new User();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setMobileNo(userDTO.getMobileNo());

            User savedUser = userRepository.save(user);
            userDTO.setId(savedUser.getId().intValue()); // Converting Long to int
            return userDTO;
        } catch (Exception e) {
            logger.error("Error saving user: ", e);
            return null;
        }
    }

    public UserDTO getUser(String email, String password) {
        try {
            User user = userRepository.findByEmail(email);
            if (user != null && user.getPassword().equals(password)) {
                UserDTO userDTO = new UserDTO();
                userDTO.setId(user.getId().intValue()); // Converting Long to int
                userDTO.setName(user.getName());
                userDTO.setEmail(user.getEmail());
                userDTO.setPassword(user.getPassword());
                userDTO.setMobileNo(user.getMobileNo());
                return userDTO;
            }
            return null;
        } catch (Exception e) {
            logger.error("Error getting user: ", e);
            return null;
        }
    }

    public boolean authenticate(String email, String password) {
        try {
            User user = userRepository.findByEmail(email);
            return user != null && user.getPassword().equals(password);
        } catch (Exception e) {
            logger.error("Error authenticating user: ", e);
            return false;
        }
    }
}
