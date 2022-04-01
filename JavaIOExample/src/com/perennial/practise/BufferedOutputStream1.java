package com.perennial.practise;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream1 {
public void bufferedOutputStream() throws IOException {
      FileOutputStream fout=new FileOutputStream("D:\\testOut1.txt");
      BufferedOutputStream bout=new BufferedOutputStream(fout);
     String s="Welcome to perennial System at last";
     byte b[]=s.getBytes();
     bout.write(b);
     bout.flush();
    bout.close();
    fout.close();
    System.out.println("Success");
}}
