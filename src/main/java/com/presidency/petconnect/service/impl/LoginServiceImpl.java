package com.presidency.petconnect.service.impl;

import com.presidency.petconnect.dto.AuthResponseDto;
import com.presidency.petconnect.dto.LoginRequestDto;
import com.presidency.petconnect.entity.Shelter;
import com.presidency.petconnect.entity.User;
import com.presidency.petconnect.mapper.ShelterMapper;
import com.presidency.petconnect.mapper.UserMapper;
import com.presidency.petconnect.repository.ShelterRepository;
import com.presidency.petconnect.repository.UserRepository;
import com.presidency.petconnect.security.JwtUtil;
import com.presidency.petconnect.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShelterRepository shelterRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public AuthResponseDto loginUser(LoginRequestDto loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid username/password.");
        }
        String token = jwtUtil.generateToken(user.getEmail(), "USER",user.getUserId());
        return new AuthResponseDto(token, "USER");
    }

    @Override
    public AuthResponseDto loginShelter(LoginRequestDto loginRequest) {
        Shelter shelter = shelterRepository.findByEmail(loginRequest.getEmail());
        if (shelter == null || !shelter.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid username/password.");
        }
        String token = jwtUtil.generateToken(shelter.getEmail(), "SHELTER", shelter.getShelterId());
        return new AuthResponseDto(token, "SHELTER");
    }
}
