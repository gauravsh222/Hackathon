package com.cisco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cisco.kafka.KafkaProducer;
import com.cisco.model.Device;

@RestController
@RequestMapping("/device")
public class DeviceController {
	
	@Autowired
	KafkaProducer producer;
	
	
	 @RequestMapping(value = "/init", method = RequestMethod.GET)
	   public ModelAndView init() {
	      return new ModelAndView("addDevice", "command", new Device());
	   }
	
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String publish(@ModelAttribute("device") Device d){
		System.out.print(d.getNode());
		System.out.print(d.getIpAddress());
		System.out.print(d.getTerminalIP());
		System.out.println(d.getPort());
		System.out.println("publisher called adding device");
		producer.send(d.getNode());
		return "done";
	}
	
/*	@RequestMapping("/devices")
	public String getDevice(){
		System.out.println("subscriber called");
		System.out.println(storage.toString());
		return storage.toString();
	}*/
}
