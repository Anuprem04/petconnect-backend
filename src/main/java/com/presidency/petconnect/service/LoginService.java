package com.presidency.petconnect.service;

import com.presidency.petconnect.dto.AuthResponseDto;
import com.presidency.petconnect.dto.LoginRequestDto;
import com.presidency.petconnect.dto.ShelterDto;
import com.presidency.petconnect.dto.UserDto;

public interface LoginService {
    AuthResponseDto loginUser(LoginRequestDto loginRequest);
    AuthResponseDto  loginShelter(LoginRequestDto loginRequest);
}
