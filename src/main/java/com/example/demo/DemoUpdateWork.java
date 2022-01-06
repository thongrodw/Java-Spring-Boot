package com.example.demo;

import com.example.demo.AWD.UpdateWork;
import com.example.demo.services.HttpRequestService;

public class DemoUpdateWork {

    public static void main(String[] args) {

        String Authentication = "B2BAuthen";
        HttpRequestService Service = new HttpRequestService(Authentication,"DSTSETUP","Passwd@2");

        String businessAreaName = "SAMPLEBA";
        String typeName = "SAMPLEWT";

        //Constructor
        UpdateWork work = new UpdateWork(businessAreaName,typeName);

        //Required Parameter
        String workId = "2022-01-04-02.34.34.775200T01";
        String formId = "1641285316885";

        //Update Status
        work.updateStatus(workId,"PROCESSED");

        //Request to AWD Server
        work.initialize(workId,formId,Authentication);
    }
}
