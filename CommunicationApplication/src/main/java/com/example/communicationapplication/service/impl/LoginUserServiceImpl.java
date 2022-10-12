package com.example.communicationapplication.service.impl;

import com.example.communicationapplication.entity.CommunicationSignUpPage;
import com.example.communicationapplication.repository.CommunicationSignUpRepository;
import com.example.communicationapplication.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginUserService {
     @Autowired
    CommunicationSignUpRepository communicationSignUpRepository;
   @Override
    public ResponseEntity<String> getLoginByUser(String email, String phone, String password){
        CommunicationSignUpPage signUpPage=new CommunicationSignUpPage();

        if(email.equals(communicationSignUpRepository.findById(Long.parseLong(signUpPage.getEmail()))) && password.equals(communicationSignUpRepository.findById(Long.parseLong(signUpPage.getPassword())))){
            return ResponseEntity.ok("Login Successfully");
        } else if (phone.equals(communicationSignUpRepository.findById(Long.parseLong(signUpPage.getPhone()))) && password.equals(communicationSignUpRepository.findById(Long.parseLong(signUpPage.getPassword())))) {
            return ResponseEntity.ok("Login Successfully");
        }else{
            return ResponseEntity.ok("Access Denied");
        }}

}
