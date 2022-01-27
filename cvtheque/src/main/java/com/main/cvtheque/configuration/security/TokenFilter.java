package com.main.cvtheque.configuration.security;

import com.main.cvtheque.exception.security.CustomSecurityException;
import com.main.cvtheque.util.AccessToken;
import com.main.cvtheque.util.ITokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenFilter extends OncePerRequestFilter {
    @Autowired
    private ITokenProvider tokenProvider;

    @Override

    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        AccessToken accessToken = tokenProvider.getTokenFromHeader(httpServletRequest);
        try {
            if (checkAccessToken(accessToken)) {
                Authentication authentication = tokenProvider.getAuthentication(accessToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
        // Catch CustomSecurityException Before Global Exception Handler for clearing Context
        catch (CustomSecurityException customSecurityException) {
            SecurityContextHolder.clearContext();
            // throw again
            throw customSecurityException;
        }

    }
    private boolean checkAccessToken(AccessToken accessToken) {
        if (accessToken == null) return false;
        return tokenProvider.validateToken(accessToken);
    }
}
