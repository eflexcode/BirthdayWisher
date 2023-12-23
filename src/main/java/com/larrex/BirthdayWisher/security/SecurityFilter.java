package com.larrex.BirthdayWisher.security;

import com.larrex.BirthdayWisher.exception.ApiKeyException;
import com.larrex.BirthdayWisher.wisher.entity.ApiUser;
import com.larrex.BirthdayWisher.wisher.service.ApiUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final ApiUserService apiUserService;

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String sentKey = request.getHeader("Apikey");

        if (sentKey == null) {

            throw new ApiKeyException("apikey not found");

        }
        ApiUser apiUser = apiUserService.getApiUser(sentKey);

        new ApiKeyAuth(sentKey, AuthorityUtils.NO_AUTHORITIES);

        filterChain.doFilter(request, response);
    }
}
