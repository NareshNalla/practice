package com.naresh.old.javapractice.gfg.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessAll {
	public static void main(String[] args) throws IOException{
		// Creating a new RandomAccessFile - "GEEK"
        RandomAccessFile geek = new RandomAccessFile("GEEK.txt", "rw");

        // Writing to file
        geek.writeUTF("Hello Geeks For Geeks");

        // File Pointer at index position - 0
        geek.seek(0);

        // read() method :
        System.out.println("Use of read() method : " + geek.read());

        geek.seek(0);

        byte[] b = {1, 2, 3};
         
        // Use of .read(byte[] b) method :
        System.out.println("Use of .read(byte[] b) : " + geek.read(b));

        // readBoolean() method :
        System.out.println("Use of readBoolean() : " + geek.readBoolean());

        // readByte() method :
        System.out.println("Use of readByte() : " + geek.readByte());

        geek.writeChar('c');
        geek.seek(0);

        // readChar() :
        System.out.println("Use of readChar() : " + geek.readChar());


        // readFloat() :
        System.out.println("Use of readFloat() : " + geek.readFloat());

        geek.seek(0);
        // Create array upto geek.length
        byte[] arr = new byte[(int) geek.length()];
        // readFully() :
        geek.readFully(arr);
         
        String str1 = new String(arr);
        System.out.println("Use of readFully() : " + str1);

        geek.seek(0);
         
        // readFully(byte[] b, int off, int len) :
        geek.readFully(arr, 0, 8);
         
        String str2 = new String(arr);
        System.out.println("Use of readFully(byte[] b, int off, int len) : " + str2);
        
        geek.seek(0);
        
        // Use of readUTF() :
        System.out.println("Use of readUTF() : " + geek.readUTF());

        //Use of seek() :
        geek.seek(0);

        // Use of readLine() :
        System.out.println("1 readLine() : " + geek.readLine());
        geek.seek(0);

        geek.writeUTF("Hello \nGeeks For Geeks");
        geek.seek(0);

        System.out.println("2 readLine() : " + geek.readLine());

        geek.seek(3);
        // Use of readUnsignedByte() :
      System.out.println("Use of readUnsignedByte() :  " + geek.readUnsignedByte());

        geek.seek(4);
        // Use of readUnsignedShort() :
      System.out.println("Use of readUnsignedByte() :  " + geek.readUnsignedShort());

        // Use of setLength():
        geek.setLength(78);

        // Use of length() :
        System.out.println("Use of setLength() : " + geek.length());

        geek.seek(2);
        // Use of skipBytes() :
        System.out.println("Use of skipBytes() : " + geek.skipBytes(3));


        // Use of getFilePointer() :
        System.out.println("Use of getFilePointer() : " + geek.getFilePointer());

        // Use of getChannel() :
        System.out.println("Use of getChannel() : " + geek.getChannel());

        // Use of getFD() :
        System.out.println("Use of getFD() : " + geek.getFD());

        
		
	}

}
