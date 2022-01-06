package com.example.demo.AWD;

import com.example.demo.services.HttpRequestService;

import java.util.HashMap;

public class UpdateWork {

    String businessAreaName;
    String typeName;
    HashMap<String, String> instance = new HashMap<String, String>();

    //Create instance
    public UpdateWork(String businessAreaName, String typeName){
        this.businessAreaName = businessAreaName;
        this.typeName = typeName;

        //Add Instance
        this.instance.put("businessAreaName",this.businessAreaName);
        this.instance.put("typeName",this.typeName);
    }

    //Update instance
    public void updateStatus(String id, String status){
        this.instance.put("@id",id);
        this.instance.put("statusName",status);
    }

    //Request
    public void initialize(String id,String formId, String authentication){

        String AuthenMethod = null;

        if(authentication == "BasicAuthen"){
            AuthenMethod = "awd";
        }
        else if(authentication == "B2BAuthen"){
            AuthenMethod= "b2b";
        }
        else{
            AuthenMethod= "awd";
        }

//        String url = "http://10.62.25.70/awdServer/"+AuthenMethod+"/services/v1/instances/"+id+"/form?_="+formId;
        String url = "http://10.62.25.70/awdServer/"+AuthenMethod+"/services/v1/instances";

        HashMap<String, HashMap<String, HashMap<String, String>>> updateInstances = new HashMap<>();
        HashMap<String, HashMap<String, String>> updateInstance = new HashMap<>();
        updateInstance.put("updateInstance", this.instance);
        updateInstances.put("updateInstances", updateInstance);

        System.out.println(HttpRequestService.PUT(url,updateInstances));
    }

    public static void main(String[] args) {

//        String Authentication = "B2BAuthen";
        String Authentication = "BasicAuthen";
        HttpRequestService Service = new HttpRequestService(Authentication,"DSTSETUP","Passwd@2");

        String businessAreaName = "SAMPLEBA";
        String typeName = "SAMPLEWT";

        //Constructor
        UpdateWork work = new UpdateWork(businessAreaName,typeName);

        //Required Parameter
        String workId = "2022-01-06-01.02.27.565280T01";
        String formId = "1641457458896";

        //Update Status
        work.updateStatus(workId,"PROCESSED");

        //Request to AWD Server
        work.initialize(workId,formId,Authentication);
    }

}
