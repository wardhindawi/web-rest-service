package com.home.restful.service;

import java.text.ParseException;
import java.util.Map;

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
        Person person = new Person();
        if (repository.getPerson(person) == null) {
            person.setId(1);
            person.setFirstName("Ibrahim");
            person.setLastName("Sawalha");
            repository.addPerson(person);
        }
    }

    public Map<Integer, Person> getAllPersons() {

        return repository.getPersons();

    }

    public Person getPerson(int personId) {
        Person person = new Person();
        person.setId(personId);
        person = repository.getPerson(person);
        if (person == null) {
            throw new DataNotFoundException("Insurance with id " + personId + " not found");
        }

        return person;
    }

    public Person addPerson(Person person) throws ParseException {
        return repository.addPerson(person);
    }

    public void deletePerson(int personId) {
        Person person = new Person();
        person.setId(personId);
        repository.deletePerson(person);

    }

    public Person updatePerson(Person person) throws ParseException {
        Person tempPerson = repository.getPerson(person);
        if (tempPerson == null) {
            throw new DataNotFoundException("Insurance with id " + person.getId() + " not found");
        }
        person.getInsurances();
        person.setJoinedDate(person.getJoinedDate());
        // person.setLinks(tempPerson.getLinks());
        return repository.updatePerson(person);

    }
}
