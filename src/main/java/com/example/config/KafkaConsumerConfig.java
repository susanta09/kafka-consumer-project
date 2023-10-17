package com.example.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

import com.example.constants.AppConstents;
import com.example.model.Order;

@Component
public class KafkaConsumerConfig {
	@Bean
	public ConsumerFactory<String, Order> consumerFactory()
	{
		Map<String , Object> configProps=new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstents.class);
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(configProps);
	}
	@Bean
	public  ConcurrentKafkaListenerContainerFactory<String,Order> kafkaListnerFactory()
	{
		 ConcurrentKafkaListenerContainerFactory<String,Order> factory=new ConcurrentKafkaListenerContainerFactory<>();
		 factory.setConsumerFactory(consumerFactory());
		 return factory;
	}
}
