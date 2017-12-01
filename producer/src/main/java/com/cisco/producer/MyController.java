package com.cisco.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/producer")
public class MyController {
	
	@Autowired
	private KafkaTemplate<String, Device> template;

	@RequestMapping(value="/init", method=RequestMethod.GET)
	public ModelAndView init(){
		return new ModelAndView("addDevice", "device", new Device());
	}
	
	@RequestMapping(value="/pub", method=RequestMethod.POST)
	public void produce(@ModelAttribute Device device) {
		ListenableFuture<SendResult<String, Device>> obj = template.send(new ProducerRecord<String, Device>("VSLP", device));
		System.out.println("isDone : " + obj.isDone());
	}
}
