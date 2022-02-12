package com.example.demo.AWD;

import com.example.demo.services.HttpRequestService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdateWork {

    String businessAreaName;
    String typeName;
    HashMap<String, Object> instance = new HashMap<String, Object>();

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

    //Add FieldValue
    public void addFieldValue(Object fieldValue){
        this.instance.put("fieldValues", fieldValue);
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

        String url = "http://10.62.25.70/awdServer/"+AuthenMethod+"/services/v1/instances";

        List<HashMap<String, HashMap<String, Object>>> updateList = new ArrayList<>();
        HashMap<String, List<HashMap<String, HashMap<String, Object>>>> updateInstances = new HashMap<>();
        HashMap<String, HashMap<String, Object>> updateInstance = new HashMap<>();

        updateInstance.put("updateInstance", this.instance);
        updateList.add(updateInstance);
        updateInstances.put("updateList", updateList);

        new LockWork(id,authentication);
        System.out.println(HttpRequestService.PUT(url,updateInstances));
    }

    public static void main(String[] args) {

        String Authentication = "B2BAuthen";
//        String Authentication = "BasicAuthen";

        HttpRequestService Service = new HttpRequestService(Authentication,"DSTSETUP","Passwd@2");

        String businessAreaName = "FINANCE";
        String typeName = "APPLY";

        //Constructor
        UpdateWork work = new UpdateWork(businessAreaName,typeName);

//        //Create Field Value
//        CreateFieldValue fieldValue = new CreateFieldValue();
//        fieldValue.setFieldValue("FNAM","Wongsatorn");
//        fieldValue.setFieldValue("LNAM","Thongrod");
//        fieldValue.setFieldValue("EMAL","Thongrod");
//        fieldValue.setFieldValue("CRED","SILVER");
//        fieldValue.setFieldValue("INCO","50000");
//        fieldValue.setFieldValue("LOBF","Hello");
//
//        //Add FieldValue to Instance
//        Object fieldValueObject = fieldValue.getFieldValue();
//        work.addFieldValue(fieldValueObject);

        //Required Parameter
        String workId = "2022-01-12-22.40.29.444460T01";
        String formId = "1641285316885";

        //Update Status
        work.updateStatus(workId,"_NEXT");

        //Request to AWD Server
        work.initialize(workId,formId,Authentication);
    }

}
