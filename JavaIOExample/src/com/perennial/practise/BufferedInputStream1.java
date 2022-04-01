package com.perennial.practise;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStream1 {
    public void bufferedInputStream() throws IOException {
        FileInputStream fin=new FileInputStream("D:\\testOut1.txt");
        BufferedInputStream bin=new BufferedInputStream(fin);
        int i;
        while(( i=bin.read())!=-1){
            System.out.print((char)i);
        }
        bin.close();
        fin.close();
    }
}
