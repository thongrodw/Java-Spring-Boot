package com.example.demo.AWD;

import com.example.demo.services.HttpRequestService;

import java.util.HashMap;

public class LockWork {

    //Create instance
    public LockWork(String id, String authentication){

        String AuthenMethod= null;

        if(authentication == "BasicAuthen"){
            AuthenMethod = "awd";
        }
        else if(authentication == "B2BAuthen"){
            AuthenMethod= "b2b";
        }
        else {
            AuthenMethod= "awd";
        }

        String lockUrl = "http://10.62.25.70/awdServer/"+AuthenMethod+"/services/v1/user/instances/"+id+"/locked";

        HttpRequestService.PUTWithoutBody(lockUrl);
    }

}
