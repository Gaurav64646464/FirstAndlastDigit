package com.perennial.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class ReadDataUsingEnumeration {
    
    
    public void readDataUsingEnumeration() throws IOException {
        FileInputStream fis=new FileInputStream("D:\\a.txt");
        FileInputStream fis1=new FileInputStream("D:\\b.txt");
        FileInputStream fis2=new FileInputStream("D:\\c.txt");
        FileInputStream fis3=new FileInputStream("D:\\d.txt");
    
        Vector v=new Vector<>();
        v.add(fis);
        v.add(fis1);
        v.add(fis2);
        v.add(fis3);
    
        Enumeration e=v.elements();
    
        SequenceInputStream sis=new SequenceInputStream(e);
        
        int i=0;
        while((i= sis.read())!=-1){
            System.out.print((char)i);
        }
        
        sis.close();
        fis.close();fis1.close();
        fis2.close();
        fis3.close();
        System.out.print("=======================");
    }
}
