package com.main.cvtheque.service;

import com.main.cvtheque.model.DTO.UserLoginDTO;
import com.main.cvtheque.model.DTO.UserRegisterDTO;
import com.main.cvtheque.util.AccessToken;

import java.util.List;

public interface AuthService {
    AccessToken register(UserRegisterDTO userRegisterDto);

    AccessToken login(UserLoginDTO userLoginDto);


}
