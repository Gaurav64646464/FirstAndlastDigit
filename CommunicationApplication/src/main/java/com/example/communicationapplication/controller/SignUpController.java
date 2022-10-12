package com.example.communicationapplication.controller;

import com.example.communicationapplication.entity.CommunicationSignUpPage;
import com.example.communicationapplication.service.SaveRegistrationCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

      @Autowired
    SaveRegistrationCommunicationService saveRegistrationCommunicationService;

      @RequestMapping(value ="/communication/registration",method = RequestMethod.POST)
      private ResponseEntity<CommunicationSignUpPage> communicationSignUpPage(@RequestBody CommunicationSignUpPage communicationSignUpPage){
          return saveRegistrationCommunicationService.registrationOfUser(communicationSignUpPage);
      }








}
