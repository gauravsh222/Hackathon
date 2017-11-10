package com.cisco.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cisco.model.Device;

@Service
public class KafkaProducer {
	//private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, Device> kafkaTemplate;
	
	String kafkaTopic = "javainuse-topic";
	
	public void send(Device data) {
	    //log.info("sending data='{}'", data);
	    System.out.println("sending data = " + data);
//	    kafkaTemplate.send(kafkaTopic, d);
	    kafkaTemplate.send(new ProducerRecord<String, Device>(kafkaTopic, data));
	}
}
