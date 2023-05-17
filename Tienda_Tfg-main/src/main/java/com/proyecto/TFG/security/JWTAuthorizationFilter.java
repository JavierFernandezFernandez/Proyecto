package com.proyecto.TFG.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String brearerToken = request.getHeader("Authorization");

        if(brearerToken != null && brearerToken.startsWith("Bearer ")) {

            String token = brearerToken.replace("Bearer ", "");
            UsernamePasswordAuthenticationToken usernamePAT = TokenUttils.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(usernamePAT);
        }

        filterChain.doFilter(request, response);

    }
}
