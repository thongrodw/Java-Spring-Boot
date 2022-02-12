package com.example.demo.services;
import java.io.*;
import java.util.logging.Level;

public class ROSConvertInputStream {

    static String ID = "004000000002";
    static File strFile = new File("src/main/resources/"+ID);


    public ROSConvertInputStream() throws FileNotFoundException {
        throw new FileNotFoundException("File not found");
    }

    public static void checkIRConversion( InputStream file ) throws Exception
    {
        if (file.available() == 0){
            String errMsg = "Unable to convert as receiving 0 byte file from IR";
            throw new Exception(errMsg);
        }
    }

    public static void main(String[] args) throws IOException {
        InputStream image = new ByteArrayInputStream("".getBytes());

        if( image.available() == 0 ){
            System.out.println("file is zero byte");
        }
    }
}
