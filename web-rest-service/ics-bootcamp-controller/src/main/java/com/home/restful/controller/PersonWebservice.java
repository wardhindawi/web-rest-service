package com.home.restful.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;

import com.home.restful.entity.Person;
import com.home.restful.service.PersonService;

@WebService (serviceName = "persons-ws")
public class PersonWebservice {
    private PersonService service = new PersonService();

    @WebMethod
    public Person getPerson(//
            @PathParam ("personId")
            int id) {
        Person person = service.getPerson(id);
        // person.addLink(getUriForSelf(person, uriInfo), "self");
        // person.addLink(getUriForInsurance(person, uriInfo), "insurance");
        return person;

    }

    @WebMethod
    public Map<Integer, Person> getPersons() {

        Map<Integer, Person> persons = service.getAllPersons();
        for (Entry<Integer, Person> entry : persons.entrySet()) {
            System.out.println("Key:" + entry.getKey() + " " + entry.getValue());

            // entry.getValue().addLink(getUriForSelf(entry.getValue(), uriInfo), "self");

            // entry.getValue().addLink(getUriForInsurance(entry.getValue(), uriInfo), "insurance");

        }

        System.out.println(persons);
        GenericEntity<Map<Integer, Person>> entity = new GenericEntity<Map<Integer, Person>>(persons) {
        };
        return persons;
    }

    @WebMethod
    public Person addPerson(Person person) throws ParseException {
        person.setJoinedDate(new Date());
        Person newPerson = service.addPerson(person);
        // URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(newPerson.getId())).build();

        // newPerson.addLink(getUriForSelf(newPerson, uriInfo), "self");
        // newPerson.addLink(getUriForInsurance(newPerson, uriInfo), "insurance");

        return person;
    }

    @WebMethod
    public Person updatePerson(@PathParam ("personId")
    int id, Person person) throws ParseException {
        person.setId(id);
        service.updatePerson(person);
        return person;
    }

    @WebMethod
    public void deletePerson(@PathParam ("personId")
    int id) {
        service.deletePerson(id);
    }
}
