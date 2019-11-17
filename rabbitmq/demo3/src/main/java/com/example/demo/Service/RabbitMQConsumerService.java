package com.example.demo.Service;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

import lombok.AllArgsConstructor;

@Service
public class RabbitMQConsumerService {
	private static final String QUEUE = "foo.queue";
	
	@Autowired
	private EmployeeService employeeService;
	
	@RabbitListener(queues = QUEUE)
	public void receiveMessage(Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		System.out.println("Received Message from foo-queue Queue >>" + employee);
	}
}
