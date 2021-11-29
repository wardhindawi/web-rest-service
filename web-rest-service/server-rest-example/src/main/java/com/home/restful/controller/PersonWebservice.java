package com.home.restful.controller;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService (serviceName = "persons-ws")
public class PersonWebservice {

    @WebMethod
    public String sayHello(String name) {
        return "reply: " + name + ".";
    }

}
