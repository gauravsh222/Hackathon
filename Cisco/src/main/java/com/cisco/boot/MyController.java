package com.cisco.boot;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="/pub", method=RequestMethod.POST)
	public String publish(@RequestBody Person p){
		System.out.println(p.name);
		System.out.println("publisher called");
		producer.send("Hello Gaurav");
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
