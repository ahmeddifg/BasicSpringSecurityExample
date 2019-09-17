package com.springsec.app.services;

import com.springsec.app.repositories.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    private UserDetailsRepo userDetailsRepo;

    @Autowired
    public UserDetailService(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.springsec.app.entities.UserDetails userDetails = null;
        userDetails = userDetailsRepo.findByUsername(s);
        return userDetails;
    }

    public UserDetailsRepo getUserDetailsRepo() {
        return userDetailsRepo;
    }

    public void setUserDetailsRepo(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
    }
}
