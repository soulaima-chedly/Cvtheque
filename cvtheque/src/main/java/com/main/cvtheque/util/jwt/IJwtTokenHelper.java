package com.main.cvtheque.util.jwt;

import com.main.cvtheque.model.Role;
import com.main.cvtheque.util.AccessToken;
import com.main.cvtheque.util.SecretKey;

import java.util.Set;

public interface IJwtTokenHelper {
    String generateJwtToken(SecretKey secretKey, String username, Set<Role> roles);
    boolean validateJwtToken(SecretKey secretKey, AccessToken accessToken);
    String getUsernameFromJwtToken(SecretKey secretKey,AccessToken accessToken);
}
