package com.perennial.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceInputStreamExample {
   public void sequenceInputStream() throws IOException {
      FileInputStream fin1=new FileInputStream("D:\\testOut1.txt");
      FileInputStream fin2=new FileInputStream("D:\\testOut.txt");
      SequenceInputStream sis=new SequenceInputStream(fin1,fin2);
      int i;
      while((i= sis.read())!=-1){
         System.out.print((char)i);
      }
      sis.close();
      fin1.close();
      fin2.close();
      System.out.println("success1234");
   }
}
