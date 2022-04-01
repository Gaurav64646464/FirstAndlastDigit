package com.perennial.practise;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataUsingByteArrayOutputStream {
    
    public void writeDataUsingByteArrayOutputStream() throws IOException {
    FileOutputStream fos1=new FileOutputStream("D:\\testOut4.txt");
    FileOutputStream fos2=new FileOutputStream("D:\\testOut5.txt");
        ByteArrayOutputStream bas=new ByteArrayOutputStream();
        bas.write(65);
        bas.writeTo(fos1);
        bas.writeTo(fos2);
        bas.close();
        fos1.close();
        fos2.close();
        System.out.println("welcome to ByteArrayOutputStream");
}}
