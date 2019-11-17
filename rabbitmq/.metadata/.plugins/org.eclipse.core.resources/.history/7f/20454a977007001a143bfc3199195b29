package com.example.demo.Service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service
public class RabbitMQSender {
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${foo.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${foo.rabbitmq.routingkey}")
	private String routingkey;	
	//String kafkaTopic = "java_in_use_topic";
	
	public void send(Employee emp) {
		amqpTemplate.convertAndSend(exchange, routingkey, emp);
		System.out.println("Send msg = " + emp);
	    
	}
}
