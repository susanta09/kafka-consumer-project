package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.example.constants.AppConstents;

@SpringBootApplication
public class ConsumerKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerKafkaApplication.class, args);
	}

@KafkaListener(topics = AppConstents.TOPIC, groupId="group_ashokit_order")
public void subscribeMsg(String order) {
		System.out.print("*** Msg Recieved From Kafka *** :: ");
		System.out.println(order);
	//logic
}

}
