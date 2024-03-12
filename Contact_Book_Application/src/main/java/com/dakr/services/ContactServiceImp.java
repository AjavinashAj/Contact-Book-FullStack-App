package com.dakr.services;

import com.dakr.entity.Contact;
import com.dakr.repository.ContacatRepository;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactServiceImp implements ContactService {

	@Autowired
	private ContacatRepository repository;

	@Override
	public Contact create(Contact contact) {
		contact.setId((int) (Math.random() * 90000) + 10000);
		return repository.save(contact);
	}

	@Override
	public List<Contact> getAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Contact> getById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public String deleteContact(Integer id) {
		repository.deleteById(id);
		return "Contact :" + id + "  deleted Successfully...";
	}

	@Override
	public Contact updateContact(Contact contact) {
		if (repository.findById(contact.getId()).isPresent()) {
			return repository.save(contact);
		}
		return null;

	}

}
