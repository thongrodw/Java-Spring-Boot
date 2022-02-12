package com.example.demo;

import com.example.demo.AWD.CreateFieldValue;
import com.example.demo.AWD.UpdateWork;
import com.example.demo.services.HttpRequestService;

public class DemoUpdateWork {

    public static void main(String[] args) {

        String Authentication = "B2BAuthen";
        HttpRequestService Service = new HttpRequestService(Authentication,"DSTSETUP","Passwd@2");

        String businessAreaName = "FINANCE";
        String typeName = "APPLY";

        //Constructor
        UpdateWork work = new UpdateWork(businessAreaName,typeName);

//        //Create Field Value
        CreateFieldValue fieldValue = new CreateFieldValue();
        fieldValue.setFieldValue("CREDNUM","12345678945667");
        fieldValue.setFieldValue("PINUM","123456");


        //Add FieldValue to Instance
        Object fieldValueObject = fieldValue.getFieldValue();
        work.addFieldValue(fieldValueObject);

        //Required Parameter
        String workId = "2022-01-14-01.37.08.159520T01";
        String formId = "1641285316885";

        //Update
        work.updateStatus(workId,"_NEXT");

        //Request to AWD Server
        work.initialize(workId,formId,Authentication);
    }
}
