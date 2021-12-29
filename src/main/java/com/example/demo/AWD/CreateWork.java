package com.example.demo.AWD;

import com.example.demo.services.HttpService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateWork {

    String businessAreaName;
    String typeName;
    String statusName;
    String processName;
    String assignTo;
    HashMap<String, String> instance = new HashMap<String, String>();
    HashMap<String, List<HashMap<String, String>>> fieldValue = new HashMap<String, List<HashMap<String, String>>>();
    List<HashMap<String, String>> fieldValueList = new ArrayList<>();;

    //Create instance
    public CreateWork(String businessAreaName, String typeName, String statusName, String processName, String assignTo){
        this.businessAreaName = businessAreaName;
        this.typeName = typeName;
        this.statusName = statusName;
        this.processName = processName;
        this.assignTo = assignTo;

        //Add Instance
        instance.put("businessAreaName",this.businessAreaName);
        instance.put("typeName",this.typeName);
        instance.put("statusName",this.statusName);
        instance.put("processName",this.processName);
        instance.put("assignTo",this.assignTo);
    }

    //Add LOB to instance
    public void addFieldValue(String key,String value){
        HashMap<String, String> myFieldValue = new HashMap<String, String>();
        myFieldValue.put("name",key);
        myFieldValue.put("value",value);
        this.fieldValueList.add(myFieldValue);

        //Add FieldValue to Instance
        this.fieldValue.put("fieldValue",this.fieldValueList);
        this.instance.put("fieldValues", this.fieldValue);
    }

    //Request
    public void initialize(){

//        String url = "http://10.62.25.70/awdServer/awd/services/v1/instances";
        String url = "https://webhook.site/2a1954d2-29cf-4e41-b9dc-2b00b4bc6812";

        HashMap<String, HashMap<String, String>> createInstance = new HashMap<>();
        createInstance.put("createInstance", instance);

        List<HashMap<String, HashMap<String, String>>> list = new ArrayList<>();
        list.add(createInstance);

        HashMap<String, List<HashMap<String, HashMap<String, String>>>> createList = new HashMap<>();
        createList.put("createList",list);

        System.out.println(HttpService.POSTRequest(url,createList));
    }



    public static void main(String[] args) {

        String businessAreaName = "SAMPLEBA";
        String typeName = "SAMPLEWT";
        String statusName = "CREATED";
        String processName = "";
        String assignTo = "DSTSETUP";

        //Constructor
        CreateWork work = new CreateWork(businessAreaName,typeName,statusName,processName,assignTo);

        //Add LOB
        work.addFieldValue("AMTV","1234");
        work.addFieldValue("ATV","1234");

        //Request to Mock Server
//        HttpService.POSTRequest(HttpService.testServer,work.fieldValue);

        //Request to AWD Server
//        work.initialize();

    }



}
