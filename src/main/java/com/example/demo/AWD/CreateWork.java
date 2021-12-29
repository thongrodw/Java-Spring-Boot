package com.example.demo.AWD;

import com.example.demo.services.HttpService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateWork {

    String businessAreaName;
    String typeName;
    String statusName;
    String processName;
    String assignTo;
    HashMap<String, Object> instance = new HashMap<String, Object>();
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
        myFieldValue.put("@name",key);
        myFieldValue.put("value",value);
        this.fieldValueList.add(myFieldValue);

        //Add FieldValue to Instance
        this.fieldValue.put("fieldValue",this.fieldValueList);
        this.instance.put("fieldValues", this.fieldValue);
    }

    //Request
    public void initialize(){

        String url = "http://10.62.25.70/awdServer/awd/services/v1/instances";

        HashMap<String, HashMap<String, Object>> createInstance = new HashMap<>();
        createInstance.put("createInstance", instance);

        List<HashMap<String, HashMap<String, Object>>> list = new ArrayList<>();
        list.add(createInstance);

        HashMap<String, List<HashMap<String, HashMap<String, Object>>>> createList = new HashMap<>();
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

//        //Add LOB
        work.addFieldValue("AMTV","1234");
        work.addFieldValue("ATV","1234");

//        Request to AWD Server
        work.initialize();

    }



}
