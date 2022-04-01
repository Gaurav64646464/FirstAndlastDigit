package com.perennial.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadSingleCharacter {

public void readSingleCharacter() throws IOException {
    FileInputStream fileInputStream=new FileInputStream("D:\\testOut.txt");
    int i=0;
    while((i=fileInputStream.read())!=-1){
    System.out.print((char)i);}
    fileInputStream.close();
}
}
