package com.example.demo.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.servlet.http.Cookie;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ROSConvertInputStreamTest {

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
        MockImageRetrievalClient.getSingleImageAsTIFF();
    }

//    //TryCatch Exception Method
//    @Test
//    public void testTryCatchExceptionMethod( @Mocked final Cookie cookie ) throws Exception {
//
//        final ROSAFTData rosAFTData = new ROSAFTData();
//        rosAFTData.setAwdKey( new AWDKey( "2019-06-06-03.08.19.672820O01" ) );
//        final MockImageRetrievalClient IRClient = new MockImageRetrievalClient("IRServer",cookie);
//        final InputStream image = IRClient.getSingleImageAsTIFF();
//
//        try {
//            Deencapsulation.invoke( ROSConvertBatch, "checkIRConversion", image, rosAFTData.getAwdKey());
//        }catch (final Exception e){
//            assertThat(e, is("Unable to convert " + rosAFTData.getAwdKey() + " as receiving 0 byte file from IR"));
//        }
//    }
//
//    //TEST Rule Expect Exception Method
//    @Test
//    public void testRuleExpectExceltionMethod( @Mocked Cookie cookie ) throws Exception {
//
//        final String SourceID = "2019-06-06-03.08.19.672820O01";
//        final MockImageRetrievalClient IRClient = new MockImageRetrievalClient("IRServer", cookie);
//        final InputStream image = IRClient.getSingleImageAsTIFF();
//
//        thrown.expectMessage(containsString("Unable to convert "+ SourceID + " as receiving 0 byte file from IR"));
//
//        Deencapsulation.invoke(ROSConvertBatch, "checkIRConversion", image , SourceID);
//    }
}
