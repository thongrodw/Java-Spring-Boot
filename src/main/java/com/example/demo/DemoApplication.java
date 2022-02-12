package com.example.demo;

import com.example.demo.AWD.CreateFieldValue;
import com.example.demo.AWD.CreateInstance;
import com.example.demo.AWD.CreateWork;
import com.example.demo.AWD.UpdateWork;
import com.example.demo.services.HttpRequestService;
import com.example.demo.services.HttpService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//Run Application Server
//		SpringApplication.run(DemoApplication.class, args);

		//Authentication
		String Authentication = "B2BAuthen";
		HttpRequestService Service = new HttpRequestService(Authentication,"DSTSETUP","cdbhjbcsd");

		//Parameter
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
		new CreateWork(instanceObject,Authentication);


		//-------------------------Update Work-----------------------------

		//Constructor
		UpdateWork work = new UpdateWork(businessAreaName,typeName);

		//Required Parameter
		String workId = "2021-12-28-03.14.41.619160T01";
		String formId = "1640683016150";

		//Update Status
		work.updateStatus(workId,"PROCESSED");

		//Request to AWD Server
		work.initialize(workId,formId,Authentication);


		//Update Status
		work.updateStatus(workId,"ENDED");

		//Request to AWD Server
		work.initialize(workId,formId,Authentication);

	}


}
