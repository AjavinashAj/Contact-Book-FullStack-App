package com.dakr.services;

import com.dakr.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {

	// create
	Contact create(Contact contact);

	// retrive All

	List<Contact> getAll();

	// get single
	Optional<Contact> getById(Integer id);

	

	

	// delete
	
	String deleteContact(Integer id);

	// update

	Contact updateContact(Contact contact);

}
