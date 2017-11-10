package com.cisco.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.cisco.custom.DeviceDeserializer;
import com.cisco.model.Device;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
 
	@Value("${jsa.kafka.bootstrap-servers}")
	private String bootstrapServer;
	
	@Value("${jsa.kafka.consumer.group-id}")
	private String groupId;
	
	@Bean
	public ConsumerFactory<String, Device> consumerFactory() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
	   // props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, DeviceDeserializer.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, DeviceDeserializer.class);
	    return new DefaultKafkaConsumerFactory<>(props);
	}
 
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Device> kafkaListenerContainerFactory() {
	    ConcurrentKafkaListenerContainerFactory<String, Device> factory = new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactory());
	    return factory;
	}
}