package com.presidency.petconnect.service;

import com.presidency.petconnect.entity.User;
import com.presidency.petconnect.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository ;
    }

    public String createUser(User user) {
        try {
            userRepository.save(user);
        }
        catch (Exception e){
            LOGGER.error("Unable to create a user , Error Code : {}" ,e.getMessage());
        }
        return "User created succesfully";
    }
}
