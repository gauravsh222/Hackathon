package com.cisco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cisco.kafka.KafkaConsumer;
import com.cisco.kafka.KafkaProducer;
import com.cisco.model.Person;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	KafkaProducer producer;
	
	@Autowired
	KafkaConsumer consumer;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ModelAndView init() {
	   return new ModelAndView("addPerson", "command", new Person());
	}
	
	@RequestMapping(value="/pub", method=RequestMethod.POST)
	public String publish(@ModelAttribute("person") Person p){
	   System.out.println("Publisher called for Person : " + p.getName());
	   producer.send(p);
	   return "done";
	}
	
	@RequestMapping("/sub")
	public String getDevice(){
	   consumer.processMessage();
	   return "success";
	}
}

