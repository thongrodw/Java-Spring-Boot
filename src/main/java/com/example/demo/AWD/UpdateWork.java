package com.example.demo.AWD;

import com.example.demo.services.HttpService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public void initialize(String id,String formId){

//        String url = "http://10.62.25.70/awdServer/awd/services/v1/instances/2021-12-28-02.39.00.287160T01/form?_=1640679106466";
        String url = "http://10.62.25.70/awdServer/awd/services/v1/instances/"+id+"/form?_="+formId;

        HashMap<String, HashMap<String, String>> updateInstance = new HashMap<>();
        updateInstance.put("updateInstance", this.instance);

        System.out.println(HttpService.PUTRequest(url,updateInstance));
    }

    public static void main(String[] args) {

        String businessAreaName = "SAMPLEBA";
        String typeName = "SAMPLEWT";

        //Constructor
        UpdateWork work = new UpdateWork(businessAreaName,typeName);

        //Required Parameter
        String workId = "2021-12-28-03.14.41.619160T01";
        String formId = "1640683016150";

        //Update Status
        work.updateStatus(workId,"PROCESSED");

        //Request to AWD Server
        work.initialize(workId,formId);
    }



}
