package sample.weblogic.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TestWebservice {

    @WebMethod
    public String sayHello(String name) {
        return "reply: " + name + ".";
    }
}
