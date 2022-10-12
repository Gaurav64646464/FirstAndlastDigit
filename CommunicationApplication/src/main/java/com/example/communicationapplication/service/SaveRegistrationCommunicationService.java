package com.example.communicationapplication.service;

import com.example.communicationapplication.entity.CommunicationSignUpPage;
import org.springframework.http.ResponseEntity;

public interface SaveRegistrationCommunicationService {
    ResponseEntity<CommunicationSignUpPage> registrationOfUser(CommunicationSignUpPage communicationSignUpPage);
}
