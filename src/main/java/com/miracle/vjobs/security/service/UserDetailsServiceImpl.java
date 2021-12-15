package com.miracle.vjobs.security.service;

import com.miracle.vjobs.model.VUser;
import com.miracle.vjobs.repository.VUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final VUserRepository vUserRepository;

    public UserDetailsServiceImpl(VUserRepository vUserRepository) {
        this.vUserRepository = vUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!vUserRepository.existsByUsername(username)) {
            throw new UsernameNotFoundException("User with username: " + username + " does not exists");
        }
        VUser vUser = vUserRepository.findVUserByUsername(username);

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("USER"));
        return User
                .builder()
                .username(vUser.getUsername())
                .password(vUser.getPassword())
                .authorities(grantedAuthorityList)
                .build();
    }
}
