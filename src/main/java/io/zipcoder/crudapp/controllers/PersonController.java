package io.zipcoder.crudapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Person>> getPersonList() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return new ResponseEntity<>(personService.read(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.create(person), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return new ResponseEntity<>(personService.update(id, person), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Long id) {
        return new ResponseEntity<>(personService.delete(id), HttpStatus.OK);
    }
}