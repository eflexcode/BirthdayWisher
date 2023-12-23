package com.larrex.BirthdayWisher.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class ApiKeyAuth extends AbstractAuthenticationToken {

    private String apikey;

    public ApiKeyAuth(String apikey,Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.apikey = apikey;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return apikey;
    }
}
