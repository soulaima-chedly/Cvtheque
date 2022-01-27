package com.main.cvtheque.service.serviceImpl;

import com.main.cvtheque.exception.security.CustomSecurityException;
import com.main.cvtheque.model.DTO.UserLoginDTO;
import com.main.cvtheque.model.DTO.UserRegisterDTO;
import com.main.cvtheque.model.Role;
import com.main.cvtheque.model.User;
import com.main.cvtheque.repository.MainUserRepository;
import com.main.cvtheque.repository.RoleRepository;
import com.main.cvtheque.service.AuthService;
import com.main.cvtheque.util.AccessToken;
import com.main.cvtheque.util.ITokenProvider;
import com.main.cvtheque.util.constant.ApiMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
@Transactional
public class AuthServiceImpl implements AuthService {
    @Autowired
    private ITokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MainUserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AccessToken register(UserRegisterDTO userRegisterDto) {
        checkUserExistsWithUserName(userRegisterDto.getUsername());

        User user = new User();
        user.setEmail(userRegisterDto.getEmail());
        user.setUsername(userRegisterDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        user.setRoles(getRoles(userRegisterDto.getRoles()));

        userRepository.save(user);

        String username = user.getUsername();
        Set<Role> roles = user.getRoles();

        return tokenProvider.createToken(username,roles);
    }



    @Override
    public AccessToken login(UserLoginDTO userLoginDto) {
        String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            Set<Role> roles = userRepository.findByUsername(username).get().getRoles();
            return tokenProvider.createToken(username,roles);

        }catch (AuthenticationException exception) {
            throw new CustomSecurityException(ApiMessages.BAD_CREDENTIALS, HttpStatus.BAD_REQUEST);

        }

    }
    private void checkUserExistsWithUserName(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new CustomSecurityException(ApiMessages.USER_ALREADY_EXISTS,HttpStatus.BAD_REQUEST);
        }
    }
    private Set<Role> getRoles(String [] roles){
        Set<Role> userRoles = new HashSet<>();
        for(String role : roles) {
            userRoles.add(roleRepository.findByName(role));
        }
        return userRoles;
    }

}