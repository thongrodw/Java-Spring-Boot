package com.example.demo.services;

import com.example.demo.AWD.B2B;
import com.example.demo.AWD.UpdateWork;
import org.apache.catalina.User;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

public class HttpRequestService extends HttpService{

    protected static String authenticationMethod;
    private static String UserId;
    private static String Password;

    public HttpRequestService(String authenMethod, String ID, String password){
        authenticationMethod = authenMethod;
        UserId = ID;
        Password = password;
   }

    public static HttpEntity<String> AuthenHeader() throws Exception {
       HttpEntity<String> requestHeader = null;
       if (authenticationMethod == "BasicAuthen"){
           requestHeader = BasicAuthenHeader(UserId,Password);
           System.out.println(requestHeader);
       }
       else if(authenticationMethod == "B2BAuthen"){
           String signature = B2B.sign(UserId, new Date());
           requestHeader = B2BAuthenHeader(signature,UserId);
           System.out.println(requestHeader);
       }
       return requestHeader;
   }

    public String GET(String url) {

        String json = null;

        try {

            HttpEntity<String> requestHeader = AuthenHeader();

            //Request
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, requestHeader, String.class);

            //Response
            json = response.getBody();

        } catch (Exception err) {
            err.printStackTrace();
        }

        return json;
    }

    public String POST(String url, Object body) {

        String json = null;

        try {

            //HTTP Request Header for POST Request
            HttpEntity<String> header = AuthenHeader();

            //Add Body to header
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Object> requestHeader = new HttpEntity<Object>(body,headers);

            //Request
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.POST, requestHeader, String.class);

            //Response
            json = response.getBody();

        } catch (Exception err) {
            err.printStackTrace();
        }

        return json;
    }

//    public String PUT(String url, Object body) {
//
//        String json = null;
//
//        try {
//
//            //HTTP Request Header for POST Request
//            HttpEntity<String> header = AuthenHeader();
//
//            //Add Body to header
//            HttpEntity<Object> requestHeader = setHTTPBody(header,body);
//
//            //Request
//            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.PUT, requestHeader, String.class);
//
//            //Response
//            json = response.getBody();
//
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//        return json;
//    }

    public static void main(String[] args) throws Exception {
        HttpRequestService Service = new HttpRequestService("B2BAuthen","DSTSETUP","cdbhjbcsd");
        System.out.println(Service.GET("http://10.62.25.70/awdServer/b2b/services/v1/system?"));
    }

}
