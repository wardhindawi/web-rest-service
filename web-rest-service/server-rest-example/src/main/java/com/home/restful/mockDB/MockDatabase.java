package com.home.restful.mockDB;

import java.util.HashMap;
import java.util.Map;

import com.home.restful.entity.Insurance;
import com.home.restful.entity.Person;

/**
 * @author preetham
 */
public class MockDatabase {

    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();
    private static Map<Integer, Insurance> insurances = new HashMap<Integer, Insurance>();
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

    public Map<Integer, Person> getPersons() {
        return persons;
    }

    public Person getPerson(Integer id) {
        return persons.get(id);

    }

    public Person addPerson(Person person) {
        Integer id = persons.size() + 1;
        person.setId(id);
        persons.put(id, person);
        return person;
    }

    public void deletePerson(Integer id) {
        persons.remove(id);

    }

    public Person updatePerson(Person person) {
        persons.put(person.getId(), person);
        return person;

    }

    public Map<Integer, Insurance> getInsurances(Integer personId) {
        System.out.println("Person p " + persons.get(personId));
        return persons.get(personId).getInsurances();

    }

    public Insurance getInsurance(Integer personId, Integer insuranceId) {
        Map<Integer, Insurance> insuranceMap = persons.get(personId).getInsurances();
        System.out.println("Person p " + persons.get(personId));
        return insuranceMap.get(insuranceId);
    }

    public Insurance addInsurance(Integer personId, Insurance insurance) {
        Map<Integer, Insurance> insuranceMap = persons.get(personId).getInsurances();
        insurance.setId(insuranceMap.size() + 1);
        insuranceMap.put(insurance.getId(), insurance);
        System.out.println("Person p " + persons.get(personId));
        System.out.println("Insraunce p " + persons.get(personId).getInsurances());
        return insurance;

    }

    public void deleteInsurance(Integer personId, Integer insuranceId) {
        Map<Integer, Insurance> insuranceMap = persons.get(personId).getInsurances();
        insuranceMap.remove(insuranceId);
    }

    public Insurance updateInsurance(Integer personId, Insurance insurance) {
        Map<Integer, Insurance> insuranceMap = persons.get(personId).getInsurances();
        insuranceMap.put(insurance.getId(), insurance);
        return insurance;

    }

}
