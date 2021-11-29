package com.home.restful.controller;

import java.net.URI;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.home.restful.entity.Person;
import com.home.restful.service.PersonService;

// URL: http://localhost:8080/RESTfulWebServicesSample/rest/persons/
/**
 * @author preetham
 */

@Path ("/persons")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public class PersonController {

    private PersonService service = new PersonService();

    public PersonController() {
        System.out.println("Person resource constructor");
    }

    /**
     * This method gets all the person resources from the DB(map)
     * URL:http://localhost:8080/RESTfulWebServicesSample/rest/persons/
     * HTTP Method: GET
     * Response:
     * [
     * {
     * "firstName": "Forest",
     * "id": 1,
     * "joinedDate": "2016-03-16T17:01:37.923",
     * "lastName": "Gump",
     * "links": [
     * {
     * "rel": "self",
     * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/1"
     * },
     * {
     * "rel": "insurance",
     * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/1/insurances/"
     * }
     * ]
     * },
     * {
     * "firstName": "James",
     * "id": 2,
     * "joinedDate": "2016-03-16T17:08:37.001",
     * "lastName": "Bond",
     * "links": [
     * {
     * "rel": "self",
     * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/2"
     * },
     * {
     * "rel": "insurance",
     * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances/"
     * }
     * ]
     * }
     * ]
     *
     * @param uriInfo
     * @return
     */

    @GET
    public Response getPersons(@Context
    UriInfo uriInfo) {

        Map<Integer, Person> persons = service.getAllPersons();
        for (Entry<Integer, Person> entry : persons.entrySet()) {
            System.out.println("Key:" + entry.getKey() + " " + entry.getValue());

            entry.getValue().addLink(getUriForSelf(entry.getValue(), uriInfo), "self");

            entry.getValue().addLink(getUriForInsurance(entry.getValue(), uriInfo), "insurance");

        }

        System.out.println(persons);
        GenericEntity<Map<Integer, Person>> entity = new GenericEntity<Map<Integer, Person>>(persons) {
        };
        return Response.status(Status.OK).entity(entity).build();
    }

    /**
     * This method gets the person resource based on the passed id
     * URL:http://localhost:8080/RESTfulWebServicesSample/rest/persons/1
     * HTTP Method: GET
     * Response:
     * {
     * "firstName": "Forest",
     * "id": 1,
     * "joinedDate": "2016-03-16T17:01:37.923",
     * "lastName": "Gump",
     * "links": [
     * {
     * "rel": "self",
     * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/1"
     * },
     * {
     * "rel": "insurance",
     * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/1/insurances/"
     * }
     * ]
     * }
     *
     * @param id
     * @param uriInfo
     * @return
     */
    @GET
    @Path ("/{personId}")
    public Response getPerson(//
            @PathParam ("personId")
            int id, //
            @Context
            UriInfo uriInfo) {
        Person person = service.getPerson(id);
        person.addLink(getUriForSelf(person, uriInfo), "self");
        person.addLink(getUriForInsurance(person, uriInfo), "insurance");
        return Response.status(Status.OK).entity(person).build();

    }

    /**
     * This method creates a new Person resource
     * * URL: http://localhost:8080/RESTfulWebServicesSample/rest/persons/
     * HTTP Method: POST
     * Content-Type: application/json
     * Request:
     * {
     * "firstName": "Forest",
     * "lastName":"Gump"
     * }
     * Response:
     * {
     * "firstName": "Forest",
     * "id": 1,
     * "joinedDate": "2016-03-16T17:01:37.923",
     * "lastName": "Gump",
     * "links": [
     * {
     * "rel": "self",
     * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/1"
     * },
     * {
     * "rel": "insurance",
     * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/1/insurances/"
     * }
     * ]
     * }
     *
     * @param person
     * @param uriInfo
     * @return
     * @throws ParseException
     */
    @POST
    public Response addPerson(Person person, @Context
    UriInfo uriInfo) throws ParseException {
        person.setJoinedDate(new Date());
        Person newPerson = service.addPerson(person);
        URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(newPerson.getId())).build();

        newPerson.addLink(getUriForSelf(newPerson, uriInfo), "self");
        newPerson.addLink(getUriForInsurance(newPerson, uriInfo), "insurance");

        return Response.created(uri).entity(newPerson).build();
    }

    /**
     * URL: http://localhost:8080/RESTfulWebServicesSample/rest/persons/1
     * HTTP method: PUT
     * Content-Type: application/json
     * Request:
     * {
     * "firstName": "James",
     * "lastName":"Gosling"
     * }
     * Response:
     * {
     * "firstName": "James",
     * "id": 1,
     * "joinedDate": "2016-03-16T17:01:37.923",
     * "lastName": "Gosling",
     * "links": [
     * {
     * "rel": "self",
     * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/1"
     * },
     * {
     * "rel": "insurance",
     * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/1/insurances/"
     * }
     * ]
     * }
     *
     * @param id
     * @param person
     * @return
     * @throws ParseException
     */
    @PUT
    @Path ("/{personId}")
    public Response updatePerson(@PathParam ("personId")
    int id, Person person) throws ParseException {
        person.setId(id);
        service.updatePerson(person);
        return Response.status(Status.OK).entity(person).build();
    }

    /**
     * This method is used to delete the resource
     * URL: http://localhost:8080/RESTfulWebServicesSample/rest/persons/1
     * HTTP Method: DELETE
     * Response: no content
     *
     * @param id
     */
    @DELETE
    @Path ("/{personId}")
    public void deletePerson(@PathParam ("personId")
    int id) {
        service.deletePerson(id);
    }

    /**
     * This method delgates the path to Insurance resource
     * Ex: http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances
     *
     * @return
     */
    @Path ("/{personId}/insurances")
    public InsuranceController getInsuranceResource() {
        return new InsuranceController();
    }

    /**
     * This method is used to create a self link for Person resource (HATEOAS)
     *
     * @param person
     * @param uriInfo
     * @return
     */
    private String getUriForSelf(Person person, UriInfo uriInfo) {
        String uri = uriInfo.getBaseUriBuilder().path(PersonController.class).path(Long.toString(person.getId()))
                .build().toString();
        return uri;

    }

    /**
     * This method is used to create a link for insurance for Pesron resource (HATEOAS)
     *
     * @param person
     * @param uriInfo
     * @return
     */
    private String getUriForInsurance(Person person, UriInfo uriInfo) {

        String uri = uriInfo.getBaseUriBuilder().path(PersonController.class)
                .path(PersonController.class, "getInsuranceResource").path(InsuranceController.class)
                .resolveTemplate("personId", person.getId()).build().toString();
        return uri;
    }

}
