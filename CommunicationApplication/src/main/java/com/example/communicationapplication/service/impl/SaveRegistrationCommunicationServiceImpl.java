package com.example.communicationapplication.service.impl;

import com.example.communicationapplication.entity.CommunicationSignUpPage;
import com.example.communicationapplication.repository.CommunicationSignUpRepository;
import com.example.communicationapplication.service.SaveRegistrationCommunicationService;
import com.example.communicationapplication.validation.CommunicationSignUpPageValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

@Service
@Transactional
@Slf4j
public class SaveRegistrationCommunicationServiceImpl implements SaveRegistrationCommunicationService {


    @Autowired
    CommunicationSignUpRepository repository;

    CommunicationSignUpPageValidation validation=new CommunicationSignUpPageValidation();


    @Override
    public ResponseEntity<CommunicationSignUpPage> registrationOfUser(CommunicationSignUpPage communicationSignUpPage) {
          if(validation.checkCommunicationSignUpPage(communicationSignUpPage)){
              log.error("Enter the profile details again");
              throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);

          }
              CommunicationSignUpPage com = repository.save(communicationSignUpPage);
          return ResponseEntity.ok().body(com);
    }





    }


