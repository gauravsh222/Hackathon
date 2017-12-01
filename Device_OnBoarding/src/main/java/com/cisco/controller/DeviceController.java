package com.cisco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cisco.kafka.KafkaConsumer;
import com.cisco.kafka.KafkaProducer;
import com.cisco.model.Device;

@RestController
@RequestMapping("/device")
public class DeviceController {
	
	@Autowired
	KafkaProducer producer;
	
	@Autowired
	KafkaConsumer consumer;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ModelAndView init() {
	   return new ModelAndView("addDevice", "command", new Device());
	}
	
	@RequestMapping(value="/pub", method=RequestMethod.POST)
	public String publish(@ModelAttribute("device") Device d){
	   System.out.println("Publisher called for device : " + d.getNode());
	   producer.send(d);
	   return "done";
	}
	
	@RequestMapping("/sub")
	public String getDevice(){
	   consumer.processMessage();
	   return "success";
	}
}
