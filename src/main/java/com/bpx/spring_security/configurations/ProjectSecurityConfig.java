package com.bpx.spring_security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrfConfig-> csrfConfig.disable())
                .authorizeHttpRequests(
                        (requests) -> requests
                                .requestMatchers("/my-account", "/my-balance", "/my-loans", "/my-cards").authenticated()
                                .requestMatchers("/notices", "/contact", "/error", "/register").permitAll()
                );
        http.formLogin(withDefaults()); //form login
        //http.formLogin(flc -> flc.disable()); // disabled form login
        http.httpBasic(withDefaults()); //postman
        //http.httpBasic(hbc -> hbc.disable()); //disabled httpBasic login
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return PasswordEncoderFactories.createDelegatingPasswordEncoder(); //Default BCrypt but, must add {bcrypt} or any other variant before password including DB cell
        return new BCryptPasswordEncoder(); //same result as above but don't need to specify {bcrypt} before password
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() { //verifies if password is week
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }
}
