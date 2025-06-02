package com.example.MySpringBoot.filter;

import com.example.MySpringBoot.Service.JwtService;
import com.example.MySpringBoot.Service.UserService;
import com.example.MySpringBoot.advice.ApiError;
import com.example.MySpringBoot.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;
    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver handlerExceptionResolver;

    public JwtAuthFilter(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         try {


             final String authHeader = request.getHeader("Authorization");
             if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                 filterChain.doFilter(request, response);
                 return;
             }

             final String token = authHeader.substring(7);
             Long userId = jwtService.getUserIdFromToken(token);

             if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                 User user = userService.getUserById(userId);
                 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, null);
                 usernamePasswordAuthenticationToken
                         .setDetails(
                                 new WebAuthenticationDetailsSource().buildDetails(request)
                         ); // contains ip address of user
                 SecurityContextHolder
                         .getContext()
                         .setAuthentication(usernamePasswordAuthenticationToken);
             }

             filterChain.doFilter(request, response);
         }catch (Exception e){
             handlerExceptionResolver.resolveException(request,response,null,e);

         }

    }
}

