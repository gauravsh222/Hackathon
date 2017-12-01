package com.cisco.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	@Value("${jsa.kafka.topic}")
	private String kafkaTopic;
	
	public void send(Object data) {
	    kafkaTemplate.send(new ProducerRecord<String, Object>(kafkaTopic, data));
	}
}
