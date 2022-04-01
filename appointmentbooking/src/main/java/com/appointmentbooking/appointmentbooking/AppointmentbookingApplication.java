package com.appointmentbooking.appointmentbooking;

import com.appointmentbooking.appointmentbooking.model.Authority;
import com.appointmentbooking.appointmentbooking.model.User;
import com.appointmentbooking.appointmentbooking.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AppointmentbookingApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    public static void main(String[] args) {
        SpringApplication.run(AppointmentbookingApplication.class, args);
    }

    @PostConstruct
    protected void init() {
        List<Authority> authorityList = new ArrayList<>();

        authorityList.add( createAuthority ("USER","User_role"));
        authorityList.add( createAuthority("ADMIN","Admin_role"));

        User user=new User();
        user.setUserName("array64");
        user.setFirstName("array");
        user.setLastName("Saroja");
        user.setPassword(passwordEncoder.encode("Gaurav@123"));
        user.setEnabled(true);

        userDetailsRepository.save(user);
    }
    private Authority createAuthority(String roleCode,String roleDescription){
        Authority authority=new Authority();
        authority.setRoleCode(roleCode);
        authority.setRoleDescription(roleDescription);
        return authority;
    }

}
