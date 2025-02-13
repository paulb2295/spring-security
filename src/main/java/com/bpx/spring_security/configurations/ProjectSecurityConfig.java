package com.bpx.spring_security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

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

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User
                .withUsername("user")
                .password("$2a$12$GLB5x/Lc/SIQEvUf7RVPxO7cStZWnkwL/pKoVmMk.25ApCWU6IlDC") //BCrypt hashed password: #Usr<min>$
                .authorities("read")
                .build();
        UserDetails admin = User
                .withUsername("admin")
                .password("$2a$12$SFPw28NBqCkgGNmJuJDDZutoE7CePfiZnkguSBsL3jaz/pitqli5m") //BCrypt hashed password: #Adm<max>$
                .authorities("admin")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return PasswordEncoderFactories.createDelegatingPasswordEncoder(); //Default BCrypt but, must add {bcrypt} or any other variant before password
        return new BCryptPasswordEncoder(); //same result as above but don't need to specify {bcrypt} before password
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker(){ //verifies if password is week
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }
}
