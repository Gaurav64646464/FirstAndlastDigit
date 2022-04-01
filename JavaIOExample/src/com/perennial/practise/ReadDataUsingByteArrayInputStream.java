package com.perennial.practise;

import java.io.ByteArrayInputStream;

public class ReadDataUsingByteArrayInputStream {
    
    public void readDataUsingByteArrayInputStream(){
        byte b[]={65,66,67,68};
    
        ByteArrayInputStream byt=new ByteArrayInputStream(b);
        
        int k=0;
        while((k=byt.read())!=-1){
        char ch=(char)k;
            System.out.println("ASCII value of character is: "+k+"Special Character is : "+ch);
        }
    }
}
