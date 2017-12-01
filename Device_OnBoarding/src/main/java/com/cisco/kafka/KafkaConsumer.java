package com.cisco.kafka;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import com.cisco.custom.DeviceDeserializer;

@Service
public class KafkaConsumer {
	
    public void processMessage() {
         org.apache.kafka.clients.consumer.KafkaConsumer<String, Object> consumer = null;
         try{
             consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<String, Object>(getConfig()) ; 
             consumer.subscribe(Collections.singletonList("xyz"));
             while (true) {
                 ConsumerRecords<String, Object> messages = consumer.poll(100);
                 for (ConsumerRecord<String, Object> message : messages) {
                	 Object d = message.value();
                	 System.out.println("Data Type : " + d.getClass());
                	 System.out.println("Message Received, " + d);
                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         finally{
        	 consumer.close();
         }
	}

	private Properties getConfig() {
		Properties props = new Properties();
	         props.put("zookeeper.connect", "localhost:2181");
	         props.put("group.id", "VSLP_GROUP");
	         props.put("zookeeper.session.timeout.ms", "4000");
	         props.put("zookeeper.sync.time.ms", "300");
	         props.put("rebalance.backoff.ms", "40000");
	         props.put("bootstrap.servers", "localhost:9092");
	         props.put("key.deserializer", StringDeserializer.class);
	         props.put("value.deserializer", DeviceDeserializer.class);
		return props;
	}
}