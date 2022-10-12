package com.example.communicationapplication.controller;


import com.example.communicationapplication.entity.CommunicationSignUpPage;
import com.example.communicationapplication.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginUser {

    @Autowired
    LoginUserService userService;

    @RequestMapping(value ="/communication/login",method = RequestMethod.POST)
    private ResponseEntity<String> loginToUser(@RequestBody CommunicationSignUpPage com){
        return userService.getLoginByUser(com.getEmail(), com.getPhone(), com.getPassword());
    }


}
