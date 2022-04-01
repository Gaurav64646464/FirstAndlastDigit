package com.perennial.practise;

import java.io.*;

public class FilterOutputStreamWriteData {
    
    
    public void filterOutputStreamWriteData() throws IOException {
    File data=new File("D:\\testOut.txt");
    FileOutputStream file=new FileOutputStream(data);
    FilterOutputStream filter=new FilterOutputStream(file);
    String s="Welcome to Perennial";
    byte b[]=s.getBytes();
    filter.write(b);
    filter.flush();
    filter.close();
    file.close();
        System.out.println("Success");
    
    
    }
}
