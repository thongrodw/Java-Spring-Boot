package com.example.demo.AWD;

import java.util.HashMap;

public class CreateInstance {

    //Instance Parameter
    String businessAreaName;
    String typeName;
    String statusName;
    String processName;
    String assignTo;
    HashMap<String, Object> instance = new HashMap<String, Object>();

    //Create Instance
    public CreateInstance(String businessAreaName, String typeName, String statusName, String processName, String assignTo){
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

    //Add FieldValue
    public void addFieldValue(Object fieldValue){
        this.instance.put("fieldValues", fieldValue);
    }

    public HashMap<String, Object> getInstance(){
        return this.instance;
    }
}
