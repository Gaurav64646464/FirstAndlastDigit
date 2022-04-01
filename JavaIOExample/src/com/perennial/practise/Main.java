package com.perennial.practise;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        FilterOutputStreamWriteData filterOutputStreamWriteData=new FilterOutputStreamWriteData();
        filterOutputStreamWriteData.filterOutputStreamWriteData();
        DataInputStreamReadTheData dat=new DataInputStreamReadTheData();
        dat.dataInputStreamReadTheData();
        
        DataOutputStreamToWrite dos=new DataOutputStreamToWrite();
        dos.dataOutputStreamToWrite();
        
        ReadDataUsingByteArrayInputStream r=new ReadDataUsingByteArrayInputStream();
        r.readDataUsingByteArrayInputStream();
        WriteDataUsingByteArrayOutputStream writeDataUsingByteArrayOutputStream=new WriteDataUsingByteArrayOutputStream();
        writeDataUsingByteArrayOutputStream.writeDataUsingByteArrayOutputStream();
        
        ReadDataUsingEnumeration readDataUsingEnumeration=new ReadDataUsingEnumeration();
        readDataUsingEnumeration.readDataUsingEnumeration();
    SequenceInputStreamExample sise=new SequenceInputStreamExample();
    sise.sequenceInputStream();
        SequenceOutputStreamExample sose=new SequenceOutputStreamExample();
        sose.sequenceOutputStream();
    
    
    WriteByte writeByte=new WriteByte();
    writeByte.writeByte();
    WriteString writeString=new WriteString();
    writeString.writeString();
    ReadSingleCharacter readSingleCharacter=new ReadSingleCharacter();
    readSingleCharacter.readSingleCharacter();
    
    BufferedOutputStream1 bos=new BufferedOutputStream1();
    bos.bufferedOutputStream();
    
    BufferedInputStream1 bis=new BufferedInputStream1();
    bis.bufferedInputStream();
    }
}
