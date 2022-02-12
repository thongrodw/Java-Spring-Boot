package com.example.demo;

import com.example.demo.AWD.CreateFieldValue;
import com.example.demo.AWD.CreateInstance;
import com.example.demo.AWD.CreateWork;
import com.example.demo.services.HttpRequestService;

import java.util.HashMap;

public class DemoCreateWork {

    public static void main(String[] args) throws Exception {

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
