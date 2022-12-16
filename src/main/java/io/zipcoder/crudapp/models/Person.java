package io.zipcoder.crudapp.models;

// import static org.mockito.ArgumentMatchers.nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    @Column(name="firstName", length=255, nullable=false, unique=false)
    String firstName;

    @Column(name="LAST_NAME", length=255, nullable=false, unique=false)
    String lastName;

    public Person() {
    }

    public Person(Long id, String firstName, String lastName) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    
}
