package com.appointmentbookingapplication.repository;


import com.appointmentbookingapplication.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRespository extends JpaRepository<Doctor, Long> {
}





