package com.home.restful.controller;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.5
 * 2021-12-01T09:59:11.157+02:00
 * Generated source version: 3.4.5
 *
 */
@WebService(targetNamespace = "http://controller.restful.home.com/", name = "PersonWebservice")
@XmlSeeAlso({ObjectFactory.class})
public interface PersonWebservice {

    @WebMethod
    @RequestWrapper(localName = "addPerson", targetNamespace = "http://controller.restful.home.com/", className = "com.home.restful.controller.AddPerson")
    @ResponseWrapper(localName = "addPersonResponse", targetNamespace = "http://controller.restful.home.com/", className = "com.home.restful.controller.AddPersonResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.home.restful.controller.Person addPerson(

        @WebParam(name = "arg0", targetNamespace = "")
        com.home.restful.controller.Person arg0
    ) throws ParseException_Exception;

    @WebMethod
    @RequestWrapper(localName = "getPersons", targetNamespace = "http://controller.restful.home.com/", className = "com.home.restful.controller.GetPersons")
    @ResponseWrapper(localName = "getPersonsResponse", targetNamespace = "http://controller.restful.home.com/", className = "com.home.restful.controller.GetPersonsResponse")
    @WebResult(name = "_return", targetNamespace = "")
    public com.home.restful.controller.GetPersonsResponse.Return getPersons()
;

    @WebMethod
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://controller.restful.home.com/", className = "com.home.restful.controller.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://controller.restful.home.com/", className = "com.home.restful.controller.UpdatePersonResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.home.restful.controller.Person updatePerson(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        com.home.restful.controller.Person arg1
    ) throws ParseException_Exception;

    @WebMethod
    @RequestWrapper(localName = "getPerson", targetNamespace = "http://controller.restful.home.com/", className = "com.home.restful.controller.GetPerson")
    @ResponseWrapper(localName = "getPersonResponse", targetNamespace = "http://controller.restful.home.com/", className = "com.home.restful.controller.GetPersonResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.home.restful.controller.Person getPerson(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0
    );

    @WebMethod
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://controller.restful.home.com/", className = "com.home.restful.controller.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://controller.restful.home.com/", className = "com.home.restful.controller.DeletePersonResponse")
    public void deletePerson(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0
    );
}
