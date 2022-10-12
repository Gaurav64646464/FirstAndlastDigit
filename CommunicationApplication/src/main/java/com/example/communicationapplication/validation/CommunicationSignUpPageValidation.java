package com.example.communicationapplication.validation;

import com.example.communicationapplication.entity.CommunicationSignUpPage;

public class CommunicationSignUpPageValidation {

  public  boolean checkCommunicationSignUpPage(CommunicationSignUpPage  communicationSignUpPage){

      if(communicationSignUpPage.getComm_Id()<0){
          return false;
      }
      if(communicationSignUpPage.getFirstName().isEmpty() || communicationSignUpPage.getFirstName()==null){
          return false;
      }
      if(communicationSignUpPage.getSurName().isEmpty() || communicationSignUpPage.getSurName()==null){
          return false;
      }
      if(communicationSignUpPage.getGender()==null){
          return false;
      }
      if(communicationSignUpPage.getPassword().isEmpty()){
          return false;
      }
      if(communicationSignUpPage.getPhone().isEmpty() ){
          return  false;
      }
      if(communicationSignUpPage.getEmail().isEmpty()){
          return false;
      }

      return false;

  }

}
