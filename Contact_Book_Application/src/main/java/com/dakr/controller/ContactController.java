package com.dakr.controller;

import com.dakr.entity.Contact;
import com.dakr.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/save")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact){
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.create(contact));
    }

    //get all
    @GetMapping("/getAll")
    public ResponseEntity<List<Contact>>getAllContacts(){
        return ResponseEntity.ok().body(contactService.getAll());
    }

    // get Single contact using Id

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contact>> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(contactService.getById(id));
            }

            //delete

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact (@PathVariable("id") Integer id){
        return  ResponseEntity.ok().body(contactService.deleteContact(id));
    }

    // update
    @PutMapping("/update")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact){
        return ResponseEntity.ok().body(contactService.updateContact(contact));
    }
    
}
