package com.springdata.web.springdatamongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdata.web.entity.Subject;

public interface SubjectRepository extends MongoRepository<Subject, String> {

    /*public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    List<Customer> findByLastNameContaining(String name);*/
	public Subject findByBookId(String bookId);
	public void deleteByBookId(String bookId);

}
