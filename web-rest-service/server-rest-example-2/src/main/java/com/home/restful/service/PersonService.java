package com.home.restful.service;

import java.util.List;

import com.home.restful.entity.Person;
import com.home.restful.exception.DataNotFoundException;
import com.home.restful.repository.PersonRepository;

/**
 * This class is serviceImpl class. Normally this class should implement service interface and implement the
 * methods of interface
 *
 * @author preetham
 */
public class PersonService {

    private PersonRepository repository = new PersonRepository();

    public PersonService() {
        System.out.println("Person service called");
        if (repository.getPersons().isEmpty()) {
            Person person = new Person();
            person.setId(1);
            person.setFirstName("Ibrahim");
            person.setLastName("Sawalha");
            repository.addPerson(person);
        }
    }

    public List<Person> getAllPersons() {

        return repository.getPersons();

    }

    public Person getPerson(long id) {
        Person person = repository.getPerson(id);
        if (person == null) {
            throw new DataNotFoundException("Person with id " + id + " not found");
        }
        return person;
    }

    public Person addPerson(Person person) {
        return repository.addPerson(person);
    }

    public void deletePerson(long id) {
        repository.deletePerson(id);

    }

    public Person updatePerson(Person person) {
        Person tempPerson = repository.getPerson(person.getId());
        if (tempPerson == null) {
            throw new DataNotFoundException("Insurance with id " + person.getId() + " not found");
        }
        person.setInsurances(tempPerson.getInsurances());
        person.setJoinedDate(tempPerson.getJoinedDate());
        person.setLinks(tempPerson.getLinks());
        return repository.updatePerson(person);

    }
}
