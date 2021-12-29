package com.example.demo.AWD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateFieldValue {

    HashMap<String, List<HashMap<String, String>>> fieldValue = new HashMap<String, List<HashMap<String, String>>>();
    List<HashMap<String, String>> fieldValueList = new ArrayList<>();

    //Setter
    public void setFieldValue(String key,String value){
        HashMap<String, String> myFieldValue = new HashMap<String, String>();
        myFieldValue.put("@name",key);
        myFieldValue.put("value",value);

        //Add Value to List
        this.fieldValueList.add(myFieldValue);

        //Add List to Object
        this.fieldValue.put("fieldValue",this.fieldValueList);
    }

    //Getter
    public HashMap<String, List<HashMap<String, String>>> getFieldValue(){
        return fieldValue;
    }
}
