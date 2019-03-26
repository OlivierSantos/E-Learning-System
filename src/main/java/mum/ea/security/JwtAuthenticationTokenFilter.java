package mum.ea.security;

import mum.ea.exceptions.EaAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {
        super("/api/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {

        String header = httpServletRequest.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            throw new EaAuthenticationException("token missing");
        }

        String token = header.split(" ")[1];
        JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(token);
        Authentication authentication = getAuthenticationManager().authenticate(jwtAuthenticationToken);

        try {
            JwtUserDetails jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            System.out.println("--- attemptAuthentication attemptAuthentication --");
        }
        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

}
