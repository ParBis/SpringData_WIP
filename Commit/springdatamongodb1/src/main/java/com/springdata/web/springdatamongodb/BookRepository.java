package com.springdata.web.springdatamongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdata.web.entity.Book;

public interface BookRepository extends MongoRepository<Book, String> {

    /*public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    List<Customer> findByLastNameContaining(String name);*/
	public Book findByBookId(String bookId);
	public void deleteByBookId(String bookId);

}
