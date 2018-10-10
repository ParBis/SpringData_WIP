package com.springdata.web.springdatamongodb;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class MongoDBRestApplication /*implements CommandLineRunner */{

	/*@Autowired
	private BookRepository repositoryBook;
	@Autowired
	private SubjectRepository repositorySubject;*/
	
	public static void main(String[] args) {
		SpringApplication.run(MongoDBRestApplication.class, args);
	}
	

	/*@Override
	public void run(String... args) throws Exception {

		repositoryBook.deleteAll();
		// save a couple of Book
		repositoryBook.save(new Book("Partha", 12.0, 1, new java.util.Date()));
		
		// fetch all Books
		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");
		for (Book book : repositoryBook.findAll()) {
			System.out.println(book);
		}*/
		

		//repositorySubject.deleteAll();
		// save a couple of Book
		//repositorySubject.save(new Subject("Automata", 10));

		// save a couple of customers
		/*repository.deleteAll();
		repository.save(new Customer("Partha", "Smith"));
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
		
		System.out.println("Customers found with findByLastNameContaining('th'):");
		System.out.println("--------------------------------");
		repository.findByLastNameContaining("th").forEach(element -> {
			System.out.println(element.toString());
		});*/

	/*}*/
}
