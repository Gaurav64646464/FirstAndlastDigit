package com.perennial.practise;

import java.io.*;

public class SequenceOutputStreamExample {
    public void sequenceOutputStream() throws IOException {
    
        FileInputStream fin1=new FileInputStream("D:\\testOut.txt");
        FileInputStream fin2=new FileInputStream("D:\\testOut1.txt");
        FileOutputStream fout=new FileOutputStream("D:\\testOut2.txt");
        SequenceInputStream sis=new SequenceInputStream(fin1,fin2);
        
        int j;
        while((j= sis.read())!=-1){
        fout.write(j);
        }
        fout.close();
        sis.close();
        fin1.close();
        fin2.close();
        System.out.println("finally");
    }
}
