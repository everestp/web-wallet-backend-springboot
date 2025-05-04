package com.offnine.web_based_waller_backend.service.impl;

import com.offnine.web_based_waller_backend.Repo.UserRepo;
import com.offnine.web_based_waller_backend.entites.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;


@Service
@AllArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername( String phone) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByPhone(phone).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return new User(user.getPhone(), user.getPassword(), Collections.emptyList());
    }
}
