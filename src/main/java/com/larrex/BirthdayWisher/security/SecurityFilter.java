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
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final ApiUserService apiUserService;

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String sentKey = request.getHeader("Apikey");
        System.out.println(sentKey);
        if (sentKey == null) {

            throw new ApiKeyException("apikey not found");
//            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.getWriter().write(convertObjectToJson(errorResponse));
        }
        ApiUser apiUser = apiUserService.getApiUserToken(sentKey);

        ApiKeyAuth apiKeyAuth = new ApiKeyAuth(sentKey, AuthorityUtils.NO_AUTHORITIES);
        SecurityContextHolder.getContext().setAuthentication(apiKeyAuth);

        filterChain.doFilter(request, response);
    }
}
