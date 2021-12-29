package com.example.demo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class HttpService {

    public static String postmanMockServer = "https://f1e33e80-28ee-4bd6-91cc-e281b97f676e.mock.pstmn.io/post";
    public static String testServer = "https://webhook.site/2a1954d2-29cf-4e41-b9dc-2b00b4bc6812";

    public static void testAPIRequest(){
        final  String url = "https://ccbcb3ca-b738-404a-b543-daaf4e68823a.mock.pstmn.io/test";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);

        System.out.println(result);
    }

    public static void testPostRequest(){
        final  String url = "https://f1e33e80-28ee-4bd6-91cc-e281b97f676e.mock.pstmn.io/post";

        Object body = computeObject("Name","Game");

        System.out.println(POSTRequest(url,body));

    }

    public static HttpEntity<String> BasicAuthHttpHeaderEncode(){
        //Auth Credential
        String authStr= "dstsetup:Passwd@2";
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

        //Http Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic "+ base64Creds);

        //Request Header
        return new HttpEntity<String>(headers);
    }

    public static HttpEntity<String> BasicAuthHttpHeader(){
        //Auth Credential
        String username = "dstsetup";
        String password = "Passwd@2";

        //Http Header
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username,password);

        //Request Header
        return new HttpEntity<String>(headers);
    }

    public static HttpEntity<Object> BasicAuthHttpHeaderBody(Object body){
        //Auth Credential
        String username = "dstsetup";
        String password = "Passwd@2";

        //Http Header
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username,password);

//        // Body
//        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
//        requestBody.add("HeaderName", "value");

        //Request Header
        return new HttpEntity<Object>(body,headers);
    }

    public static Object computeObject(String key, String value){
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add(key,value);
        return body;
    }

    public static String GETRequest(String url) {

        HttpEntity<String> requestHeader = BasicAuthHttpHeader();

        String json = null;

        try {
            //Request
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, requestHeader, String.class);

            //Response
            json = response.getBody();

        } catch (Exception err) {
            err.printStackTrace();
        }

        return json;
    }

    public static String POSTRequest(String url, Object body) {

        //HTTP Request Header for POST Request
        HttpEntity<Object> requestHeader = BasicAuthHttpHeaderBody(body);

        String json = null;

        try {
            //Request
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.POST, requestHeader, String.class);

            //Response
            json = response.getBody();

        } catch (Exception err) {
            err.printStackTrace();
        }

        return json;
    }

    public static String PUTRequest(String url, Object body) {

        //HTTP Request Header for POST Request
        HttpEntity<Object> requestHeader = BasicAuthHttpHeaderBody(body);

        String json = null;

        try {
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
