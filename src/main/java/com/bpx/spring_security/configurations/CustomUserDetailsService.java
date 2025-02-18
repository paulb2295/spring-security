package com.bpx.spring_security.configurations;

import com.bpx.spring_security.models.entities.AppUser;
import com.bpx.spring_security.repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User details not found for the user: " + username)
        );
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(appUser.getRole()));

        return new User(appUser.getEmail(), appUser.getPwd(), authorities);
    }
}
