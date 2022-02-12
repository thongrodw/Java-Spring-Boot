package com.example.demo.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ROSConvert {

    static String ID = "004000000002";
    static File file = new File("src/main/resources/"+ID);

    public static void checkIRConversion() throws Exception
    {
        if (file.length() == 0){
            String errMsg = "Unable to convert " + file.getName() + " as receiving 0 byte file from IR";
            throw new Exception(errMsg);
        }
    }

    public static void checkIRConversion(InputStream image) throws Exception
    {
        if (image.available() == 0){
            String errMsg = "Unable to convert " + file.getName() + " as receiving 0 byte file from IR";
            throw new Exception(errMsg);
        }
    }

    public static Integer checkIR(final InputStream convertedFile) throws Exception
    {
        Integer convertResult;

        if ( convertedFile.available() == 0 )
            convertResult = 0;
        else
            convertResult = 1;

        return convertResult;
    }

    public static void main(String[] args) throws Exception {

        final List<InputStream> rosFinalList = new ArrayList<>();
        InputStream nullInputStream = new ByteArrayInputStream("".getBytes());
        InputStream anyInputStrem = new ByteArrayInputStream("Not Null".getBytes());
        rosFinalList.add(nullInputStream);
        rosFinalList.add(anyInputStrem);

        for ( final InputStream file: rosFinalList){

            if( file.available() == 0 ){
                System.out.println("Unable to convert as receiving 0 byte file from IR");
                System.out.println();
                continue;
            }

            System.out.println("Store File Success");
            System.out.println();
        }
    }
}
