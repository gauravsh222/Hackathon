package com.cisco.custom;

import java.util.Map;

import com.cisco.model.Device;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeviceSerializer implements Serializer<Device> {

	@Override
	public void configure(Map<String, ?> config, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] serialize(String topic, Device data) {
		  byte[] retVal = null;
		    ObjectMapper objectMapper = new ObjectMapper();
		    try {
		      retVal = objectMapper.writeValueAsString(data).getBytes();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return retVal;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	
}
