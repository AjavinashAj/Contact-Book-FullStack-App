package com.dakr.repository;

import com.dakr.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContacatRepository extends JpaRepository<Contact,Integer> {
}
