package io.zipcoder.crudapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {

        this.personRepository = personRepository;

    }

    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    public Person read(Long id) {
        return personRepository.findById(id).get();
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(Long id, Person person) {
        Person originalPerson = personRepository.findById(id).get();
        originalPerson.setFirstName(person.getFirstName());
        originalPerson.setLastName(person.getLastName());
        return personRepository.save(originalPerson);
    }

    public boolean delete(Long id) {
        personRepository.deleteById(id);
        return true;
    }
}
