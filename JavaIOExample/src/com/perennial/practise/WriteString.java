package com.perennial.practise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteString {
    
    
    public void writeString() throws IOException {
        FileOutputStream fout=new FileOutputStream("D:\\testOut.txt");
        String s="Welcome to Perennial";
        byte b[]=s.getBytes();
        fout.write(b);
        fout.close();
        System.out.println("Success1");
    }
}
