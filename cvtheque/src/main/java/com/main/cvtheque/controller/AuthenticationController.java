package com.main.cvtheque.controller;

import com.main.cvtheque.model.DTO.UserLoginDTO;
import com.main.cvtheque.model.DTO.UserRegisterDTO;
import com.main.cvtheque.repository.MainUserRepository;
import com.main.cvtheque.service.AuthService;
import com.main.cvtheque.util.AccessToken;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {
    @Autowired
    private AuthService authService;

    @Autowired
    private MainUserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AccessToken> register(@RequestBody UserRegisterDTO userRegisterDto) {
        AccessToken accessToken =  authService.register(userRegisterDto);
        return ResponseEntity.ok(accessToken);

    }
    @PostMapping("/login")
    public ResponseEntity<AccessToken> login(@RequestBody UserLoginDTO userLoginDto) {
        AccessToken accessToken = authService.login(userLoginDto);
        return ResponseEntity.ok(accessToken);
    }
}
