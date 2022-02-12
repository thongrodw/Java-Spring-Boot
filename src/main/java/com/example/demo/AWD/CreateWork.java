package com.example.demo.AWD;

import com.example.demo.services.HttpRequestService;
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
    public CreateWork(HashMap<String, Object> instance, String authentication){

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

        String url = "http://10.62.25.70/awdServer/"+AuthenMethod+"/services/v1/instances";
//        String url ="https://webhook.site/600cb01f-e535-406d-b5ee-338749bece23";

        HttpRequestService.POST(url,createList(instance));
    }


    public static void main(String[] args) {

        String Authentication = "B2BAuthen";

        HttpRequestService Service = new HttpRequestService(Authentication,"DSTSETUP","Passwd@2");

        String businessAreaName = "FINANCE";
        String typeName = "APPLY";
        String statusName = "CREATED";
        String processName = "";
        String assignTo = "DSTSETUP";

        //Create Instance
        CreateInstance instance = new CreateInstance(businessAreaName,typeName,statusName,processName,assignTo);

        //Create Field Value
        CreateFieldValue fieldValue = new CreateFieldValue();
        fieldValue.setFieldValue("FNAM","Wongsatorn");
        fieldValue.setFieldValue("LNAM","Thongrod");
        fieldValue.setFieldValue("EMAL","Thongrod");
        fieldValue.setFieldValue("CRED","SILVER");
        fieldValue.setFieldValue("INCO","50000");
        fieldValue.setFieldValue("LOBF","Hello");


        //Add FieldValue to Instance
        Object fieldValueObject = fieldValue.getFieldValue();
        instance.addFieldValue(fieldValueObject);

//        Request to AWD Server
        HashMap<String, Object> instanceObject = instance.getInstance();
        new CreateWork(instanceObject,Authentication);

    }

}
