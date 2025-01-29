package com.fouad.Bank.config;

import com.fouad.Bank.exceptionHandling.CustomAccessDeniedHandler;
import com.fouad.Bank.filters.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class BankSecurityConfig {
    @Bean
    public SecurityFilterChain defaultBankSecurityFilterChain (HttpSecurity http) throws Exception {

        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();

        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());

        http.sessionManagement(smc->
                smc.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration corsConfiguration = new CorsConfiguration();
                corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
                corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
                corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
                corsConfiguration.setAllowCredentials(true);
                corsConfiguration.setExposedHeaders(Arrays.asList("Authorization"));
                corsConfiguration.setMaxAge(1800L);
                return corsConfiguration;
            }
        }));

        http.csrf(csrf->
                csrf.csrfTokenRequestHandler(requestHandler)
                        .ignoringRequestMatchers("/contact","/edit")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())) ;
        http.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);

        http.requiresChannel(rcf->rcf.anyRequest().requiresInsecure());

        http.authorizeHttpRequests(request->request
                .requestMatchers("/notices", "/contact","/apiLogin").permitAll()
                .requestMatchers("/myAccount","/myAccountTransactions").hasRole("USER")
                .requestMatchers("/myBalance").hasAnyRole("USER","ADMIN")
                .requestMatchers("/myCardDetails","/myAllCards").hasRole("USER")
                .requestMatchers("/myLoans").hasRole("USER")
                .requestMatchers("/user","/edit").authenticated());

        http.oauth2ResourceServer(rsc->
                rsc.jwt(jwtConfigurer->
                        jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter)));
        http.exceptionHandling(ehc->
                ehc.accessDeniedHandler(new CustomAccessDeniedHandler()));
        return http.build();
    }

}