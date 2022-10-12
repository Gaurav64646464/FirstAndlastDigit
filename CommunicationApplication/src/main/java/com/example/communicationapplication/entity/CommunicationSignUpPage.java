package com.example.communicationapplication.entity;


import com.example.communicationapplication.Enums.Gender;
import com.example.communicationapplication.customvalidation.BGTelephone;
import com.example.communicationapplication.customvalidation.ValidPassword;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
@Data
@Entity
@Table(name = "CommunicationSignUpPage")
public class CommunicationSignUpPage implements Serializable {


    @Id
    @Column(name = "comm_Id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comm_Id;

    @Column(name = "firstName", nullable = false)
    @NotNull
    private String firstName;
    @Column(name = "surName",  nullable = false)
    @NotNull
    private String surName;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ValidPassword
    private String password;
    @BGTelephone
    private String phone;
    @Email
    private String email;

    private String  name;

}
