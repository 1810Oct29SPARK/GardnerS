package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Test;

public class TestService {
	
	private ObjectMapper om = new ObjectMapper();

	public String getTestJSON(){
		List<Test> testList = new ArrayList<Test>();
		testList.add(new Test("Message1"));
		testList.add(new Test("MessageZwei"));
		testList.add(new Test("MessageTres"));
		String testString = "";
		try {
			testString = om.writeValueAsString(testList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return testString;
	}

}