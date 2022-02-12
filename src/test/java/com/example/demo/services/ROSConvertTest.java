package com.example.demo.services;

import org.junit.jupiter.api.Test;

import javax.servlet.http.Cookie;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ROSConvertTest {

    static class MockImageRetrievalClient
    {
        public MockImageRetrievalClient(final String irServer, final Cookie sessionId) {
            //Do Nothing
        }

        static InputStream getImage(){
            return new ByteArrayInputStream("".getBytes());
        }

        static InputStream getSingleImageAsTIFF() throws IOException {
            return getImage();
        }
    }

    @Test
    void checkIRConversion() throws IOException {

    }
}