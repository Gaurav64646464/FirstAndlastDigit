package com.example.communicationapplication.repository;

import com.example.communicationapplication.entity.CommunicationSignUpPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationSignUpRepository extends JpaRepository<CommunicationSignUpPage,Long> {



}
