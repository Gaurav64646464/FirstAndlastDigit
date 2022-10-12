package com.example.communicationapplication.service;

import org.springframework.http.ResponseEntity;

public interface LoginUserService {
    ResponseEntity<String> getLoginByUser(String email, String phone, String password);
}
