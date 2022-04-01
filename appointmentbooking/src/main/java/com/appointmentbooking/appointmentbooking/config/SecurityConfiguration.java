package com.appointmentbooking.appointmentbooking.config;

import com.appointmentbooking.appointmentbooking.service.CustomerUserService;
import com.appointmentbooking.appointmentbooking.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomerUserService userDetailsService;

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.authorizeRequests().anyRequest().permitAll();
       http.authorizeRequests().anyRequest().authenticated();
       http.formLogin();
       http.httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //In-Memory
        auth.inMemoryAuthentication().withUser("Gaurav").password(passwordEncoder().encode("Gaurav@123")).authorities("USER","ADMIN");
      // Database Auth
       auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

