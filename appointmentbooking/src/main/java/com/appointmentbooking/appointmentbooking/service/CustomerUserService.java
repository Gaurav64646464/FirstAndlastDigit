package com.appointmentbooking.appointmentbooking.service;

import com.appointmentbooking.appointmentbooking.model.User;
import com.appointmentbooking.appointmentbooking.repository.UserDetailsRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserService  implements UserDetailsService {

    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userDetailsRepository.findByUsername(username);

        if(null==user){
            throw new UsernameNotFoundException("User not found with userName"+username);
        }
        return user;
    }

}
