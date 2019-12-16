package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.model.Customer;
import com.example.demo.model.User;
import com.example.demo.mongoRepository.CustomerRepository;
import com.example.demo.mysqlRepository.UserRepository;

@EnableMongoRepositories(basePackageClasses = CustomerRepository.class)
@EnableJpaRepositories (basePackageClasses = UserRepository.class)
@SpringBootApplication
public class MongoAndMysqlApplication  implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository repository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoAndMysqlApplication.class, args);
	}
	
	
	@Override
    public void run(String... args) throws Exception {

        System.out.println("getting data from Mongo");
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice"
        		+ ""
        		+ "import org.springframework.beans.factory.annotation.Autowired;\n" + 
        		"import org.springframework.boot.CommandLineRunner;\n" + 
        		"import org.springframework.boot.SpringApplication;\n" + 
        		"import org.springframework.boot.autoconfigure.SpringBootApplication;\n" + 
        		"import org.springframework.data.jpa.repository.config.EnableJpaRepositories;\n" + 
        		"import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

        System.out.println("gettting data from mysql");
        userRepository.deleteAll();

        // save a couple of customers
        User u = userRepository.save(new User("Alice", "Alice@Smith.com"));
        System.out.println(u+"=======");
        userRepository.save(new User("Bob", "Bob@Smith.com"));

        // fetch all customers
        System.out.println("Users found with findAll():");
        System.out.println("-------------------------------");

        for (User user : userRepository.findAll()) {
            System.out.println(user);
        }

    }

}
