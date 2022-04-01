package com.perennial.practise;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamToWrite {
    
    public void dataOutputStreamToWrite() throws IOException {
        FileOutputStream fos=new FileOutputStream("D:\\dataOutputStream.txt");
        DataOutputStream dos=new DataOutputStream(fos);
        dos.write(65);
        dos.size();
        dos.flush();
        dos.close();
        fos.close();
        System.out.println("DataOutputStream============================");
    }
}
