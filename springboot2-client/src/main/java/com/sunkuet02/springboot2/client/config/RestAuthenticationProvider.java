package com.sunkuet02.springboot2.client.config;

import com.sunkuet02.springboot2.client.entity.JwtTokenPayload;
import com.sunkuet02.springboot2.client.entity.LoginRequest;
import com.sunkuet02.springboot2.client.entity.LoginResponse;
import com.sunkuet02.springboot2.client.service.LoginService;
import com.sunkuet02.springboot2.client.utils.JwtParserUtils;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        LoginRequest request = LoginRequest.builder()
                .username(name)
                .password(password)
                .build();

        try {
            LoginResponse response = loginService.login(request);
            JwtTokenPayload payload = JwtParserUtils.parseTokenPayload(response.getAccess_token());

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            payload.getRoles().forEach(role-> {
                grantedAuthorities.add(new SimpleGrantedAuthority(role));
            });

            Authentication usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(response,
                    response.getAccess_token(), grantedAuthorities);

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
            return usernamePasswordAuthentication;

        } catch (Exception e) {
            throw new BadCredentialsException("Bad Credentials with username and password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
