package com.example.MySpringBoot.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String redirectUrl = "/";
        System.out.println("authorities: " + authorities);
        String role = authorities.stream().toList().get(0).toString();

        redirectUrl = switch (role) {
            case "ROLE_ADMIN" -> "/admin";
            case "ROLE_USER" -> "/user";
            case "ROLE_DEVELOPER" -> "/dev";
            default -> redirectUrl;
        };

        response.sendRedirect(redirectUrl);
    }
}
