package com.cisco.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cisco.kafka.KafkaProducer;
import com.cisco.kafka.MessageStorage;

@RestController
@RequestMapping("/kafka")
public class MyController {
	
	@Autowired
	KafkaProducer producer;
	
	@Autowired
	MessageStorage storage;
	
	
	 @RequestMapping(value = "/init", method = RequestMethod.GET)
	   public ModelAndView init() {
	      return new ModelAndView("addDevice", "command", new Device());
	   }
	
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String publish(@ModelAttribute("device") Device d){
		System.out.println(d.node);
		System.out.println(d.ipAddress);
		System.out.println(d.terminalIP);
		System.out.println(d.port);
		System.out.println("publisher called adding devic	e");
		producer.send(d.node);
		return "done";
	}
	
	@RequestMapping("/devices")
	public String getDevice(){
		System.out.println("subscriber called");
		System.out.println(storage.toString());
		return storage.toString();
	}
	
	
	@RequestMapping(value="/pub", method=RequestMethod.POST)
	public String publish(@RequestBody Person p){
		System.out.println(p.name);
		System.out.println("publisher called");
		//producer.send("Hello Gaurav");
		return "done";
	}
	
	@RequestMapping("/sub")
	public String subscribe(){
		System.out.println("subscriber called");
		System.out.println(storage.toString());
		return storage.toString();
	}
	
	
	@RequestMapping("/model")
	public ModelAndView runTest(){
		ModelAndView model = new ModelAndView();
		model.setViewName("addPerson");
		return model;
	}
	

	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView model = new ModelAndView();
		model.setViewName("success");
		return model;
	}
	
}
