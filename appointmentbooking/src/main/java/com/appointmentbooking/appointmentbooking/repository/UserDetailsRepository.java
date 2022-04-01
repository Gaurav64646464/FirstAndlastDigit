package com.appointmentbooking.appointmentbooking.repository;

import com.appointmentbooking.appointmentbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {

     User findByUsername(String username);
}
