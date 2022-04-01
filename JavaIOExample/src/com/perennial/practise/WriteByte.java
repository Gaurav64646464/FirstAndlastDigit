package com.perennial.practise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteByte {
    
    
    public void writeByte() throws IOException {
       FileOutputStream
       
            fout = new FileOutputStream("D:\\test.txt");
       
       
        fout.write(8);
        fout.close();
        System.out.println("Success");
    }
    
}
