package com.home.restful.mockDB;

import java.util.HashMap;
import java.util.Map;

import com.home.restful.entity.Insurance;
import com.home.restful.entity.Person;

/**
 * @author preetham
 */
public class MockDatabase {

    private static Map<Long, Person> persons = new HashMap<Long, Person>();
    private static Map<Long, Insurance> insurances = new HashMap<Long, Insurance>();
    private static MockDatabase mockDatabase;

    static {
        mockDatabase = new MockDatabase();
    }

    private MockDatabase() {

    }

    public static MockDatabase getInstance() {
        System.out.println("Getting db instance...");
        return mockDatabase;
    }

    public Map<Long, Person> getPersons() {
        return persons;
    }

    public Person getPerson(long id) {
        return persons.get(id);

    }

    public Person addPerson(Person person) {
        long id = persons.size() + 1;
        person.setId(id);
        persons.put(id, person);
        return person;
    }

    public void deletePerson(long id) {
        persons.remove(id);

    }

    public Person updatePerson(Person person) {
        persons.put(person.getId(), person);
        return person;

    }

    public Map<Long, Insurance> getInsurances(long personId) {
        System.out.println("Person p " + persons.get(personId));
        return persons.get(personId).getInsurances();

    }

    public Insurance getInsurance(long personId, long insuranceId) {
        Map<Long, Insurance> insuranceMap = persons.get(personId).getInsurances();
        System.out.println("Person p " + persons.get(personId));
        return insuranceMap.get(insuranceId);
    }

    public Insurance addInsurance(long personId, Insurance insurance) {
        Map<Long, Insurance> insuranceMap = persons.get(personId).getInsurances();
        insurance.setId(insuranceMap.size() + 1);
        insuranceMap.put(insurance.getId(), insurance);
        System.out.println("Person p " + persons.get(personId));
        System.out.println("Insraunce p " + persons.get(personId).getInsurances());
        return insurance;

    }

    public void deleteInsurance(long personId, long insuranceId) {
        Map<Long, Insurance> insuranceMap = persons.get(personId).getInsurances();
        insuranceMap.remove(insuranceId);
    }

    public Insurance updateInsurance(long personId, Insurance insurance) {
        Map<Long, Insurance> insuranceMap = persons.get(personId).getInsurances();
        insuranceMap.put(insurance.getId(), insurance);
        return insurance;

    }

}
