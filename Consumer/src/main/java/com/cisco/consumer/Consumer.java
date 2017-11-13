package com.cisco.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class Consumer {
	  
	  @KafkaListener(topics = "${jsa.kafka.topic}")
	  public void receive(ConsumerRecord<?, ?> consumerRecord) {
		  System.out.println("Payload for cisco =" + consumerRecord.toString());
		  System.out.println("Data Type of payload  =" + consumerRecord.value().getClass());
		  System.out.println("Value of payload =" + consumerRecord.value());
	  }
}
