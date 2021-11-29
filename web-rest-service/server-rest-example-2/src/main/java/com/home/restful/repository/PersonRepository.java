package com.home.restful.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.home.restful.entity.Person;
import com.home.restful.mockDB.MockDatabase;

/**
 * @author preetham
 */
public class PersonRepository {

    private MockDatabase mockDatabase = MockDatabase.getInstance();

    public PersonRepository() {
        System.out.println("Person repository called");
    }

    public List<Person> getPersons() {
        List<Person> personList = null;
        Map<Long, Person> persons = mockDatabase.getPersons();
        if (persons != null) {
            personList = new ArrayList<Person>(persons.values());
        }
        return personList;
    }

    public Person getPerson(long id) {
        return mockDatabase.getPerson(id);
    }

    public Person addPerson(Person person) {
        return mockDatabase.addPerson(person);
    }

    public void deletePerson(long id) {
        mockDatabase.deletePerson(id);

    }

    public Person updatePerson(Person person) {
        return mockDatabase.updatePerson(person);

    }
}
