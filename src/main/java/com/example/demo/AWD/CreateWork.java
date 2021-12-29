package com.example.demo.AWD;

import com.example.demo.services.HttpService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateWork {

    //Create List
    public static HashMap<String, List<HashMap<String, HashMap<String, Object>>>> createList(HashMap<String, Object> instance){
        HashMap<String, HashMap<String, Object>> createInstance = new HashMap<>();
        createInstance.put("createInstance", instance);
//
        List<HashMap<String, HashMap<String, Object>>> list = new ArrayList<>();
        list.add(createInstance);

        HashMap<String, List<HashMap<String, HashMap<String, Object>>>> createList = new HashMap<>();
        createList.put("createList",list);

        return createList;
    }

    //Create instance
    public CreateWork(HashMap<String, Object> instance){

        String url = "http://10.62.25.70/awdServer/awd/services/v1/instances";

        HttpService.POSTRequest(url,createList(instance));
    }


    public static void main(String[] args) {

        String businessAreaName = "SAMPLEBA";
        String typeName = "SAMPLEWT";
        String statusName = "CREATED";
        String processName = "";
        String assignTo = "DSTSETUP";

        //Create Instance
        CreateInstance instance = new CreateInstance(businessAreaName,typeName,statusName,processName,assignTo);

        //Create Field Value
        CreateFieldValue fieldValue = new CreateFieldValue();
        fieldValue.setFieldValue("AMTV","1234");
        fieldValue.setFieldValue("ATV","1234");

        //Add FieldValue to Instance
        Object fieldValueObject = fieldValue.getFieldValue();
        instance.addFieldValue(fieldValueObject);

//        Request to AWD Server
        HashMap<String, Object> instanceObject = instance.getInstance();
        new CreateWork(instanceObject);

    }

}
