package com.bpx.spring_security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (requests) -> requests
                        .requestMatchers("/my-account", "/my-balance", "/my-loans", "/my-cards").authenticated()
                        .requestMatchers("/notices", "/contact", "/error").permitAll()
        );
        http.formLogin(withDefaults()); //form login
        //http.formLogin(flc -> flc.disable()); // disabled form login
        http.httpBasic(withDefaults()); //postman
        //http.httpBasic(hbc -> hbc.disable()); //disabled httpBasic login
        return http.build();
    }
}
