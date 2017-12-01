package com.cisco.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class Consumer {
	  
	  @KafkaListener(topics = "${jsa.kafka.topic.vslp}")
	  public void receive_vslp(ConsumerRecord<?, ?> consumerRecord) {
		  System.out.println("Payload for vslp = " + consumerRecord.toString());
		  System.out.println("Data Type of payload = " + consumerRecord.value().getClass());
		  System.out.println ("Value of payload = " + consumerRecord.value());
	  }
	  
	  @KafkaListener(topics = "${jsa.kafka.topic.xyz}")
	  public void receive_cisco(ConsumerRecord<?, ?> consumerRecord) {
		  System.out.println("Payload for xyz = " + consumerRecord.toString());
		  System.out.println("Data Type of payload = " + consumerRecord.value().getClass());
		  System.out.println ("Value of payload = " + consumerRecord.value());
	  }
}
