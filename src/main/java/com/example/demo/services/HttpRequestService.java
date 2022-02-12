package com.example.demo.services;

import com.example.demo.AWD.B2B;
import com.example.demo.AWD.CreateFieldValue;
import com.example.demo.AWD.CreateInstance;
import com.example.demo.AWD.CreateWork;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

public class HttpRequestService extends HttpService{

    protected static String authenticationMethod;
    private static String UserId;
    private static String Password;

    public HttpRequestService(String authenMethod, String ID, String password){
        authenticationMethod = authenMethod;
        UserId = ID;
        Password = password;
   }

    public static HttpHeaders AuthenHeader() throws Exception {
        HttpHeaders headers = new HttpHeaders();
       if (authenticationMethod == "BasicAuthen"){
           headers.setBasicAuth(UserId,Password);
       }
       else if(authenticationMethod == "B2BAuthen"){
           String signature = B2B.sign(UserId, new Date());
           headers.add("remote_user", UserId);
//           headers.add("B2BSignature", signature);
       }
       return headers;
   }

    public static String GET(String url) {

        String json = null;

        try {

            HttpHeaders requestHeader = AuthenHeader();
            HttpEntity<String> headers = new HttpEntity<String>(requestHeader);

            //Request
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, headers, String.class);

            //Response
            json = response.getBody();

        } catch (Exception err) {
            err.printStackTrace();
        }

        return json;
    }

    public static String POST(String url, Object body) {

        String json = null;

        try {

            //HTTP Request Header for POST Request
            HttpHeaders header = AuthenHeader();
            HttpEntity<Object> requestHeader = new HttpEntity<Object>(body,header);

            System.out.println(requestHeader);

            //Request
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.POST, requestHeader, String.class);

            //Response
            json = response.getBody();

        } catch (Exception err) {
            err.printStackTrace();
        }

        return json;
    }

    public static String PUT(String url, Object body) {

        String json = null;

        try {

            //HTTP Request Header for POST Request
            HttpHeaders header = AuthenHeader();
            HttpEntity<Object> requestHeader = new HttpEntity<Object>(body,header);

            //Request
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.PUT, requestHeader, String.class);

            //Response
            json = response.getBody();

        } catch (Exception err) {
            err.printStackTrace();
        }

        return json;
    }

    public static String PUTWithoutBody(String url) {

        String json = null;

        try {

            //HTTP Request Header for POST Request
            HttpHeaders header = AuthenHeader();
            HttpEntity<String> requestHeader = new HttpEntity<String>(header);

            //Request
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.PUT, requestHeader, String.class);

            //Response
            json = response.getBody();

        } catch (Exception err) {
            err.printStackTrace();
        }

        return json;
    }

}
