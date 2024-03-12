package com.chivalrycode.expensetracker.security;

import com.chivalrycode.expensetracker.configuration.JwtFilterConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.http.HttpMethod.POST;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityFilterChainConfig {
    private final AuthenticationProvider authenticationProvider;
    private final JwtFilterConfiguration filterConfiguration;
    private final CorsConfigurationSource corsConfigurationSource;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->
                        configurer
                                .requestMatchers("/api/v1","/api/v1/auth/**","/password/**", "/events/view-event/**",
                                        "/v3/api-docs",
                                        "/v3/api-docs",
                                        "/v3/api-docs/**",
                                        "/swagger-resources",
                                        "/swagger-resources/**",
                                        "/configuration/ui",
                                        "/configuration/security",
                                        "/swagger-ui/**",
                                        "/webjars/**",
                                        "/swagger-ui.html")
                                .permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/categories/**").permitAll()
                                .requestMatchers(POST,"/api/categories/**").permitAll()
                                .requestMatchers(HttpMethod.PUT,"/api/categories/**").permitAll()
                                .requestMatchers(HttpMethod.DELETE,"/api/categories/**").permitAll()
                                .requestMatchers(POST, "/api/auth/**").permitAll()
                                .requestMatchers("/api/expense/**").authenticated()

                ).sessionManagement((session) ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(filterConfiguration, UsernamePasswordAuthenticationFilter.class);

        http.csrf(csrf->csrf.disable());
        http.cors().configurationSource(corsConfigurationSource);
        return http.build();
    }
}


