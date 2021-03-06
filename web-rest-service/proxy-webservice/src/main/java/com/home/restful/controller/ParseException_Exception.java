
package com.home.restful.controller;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.4.5
 * 2021-12-01T09:59:11.152+02:00
 * Generated source version: 3.4.5
 */

@WebFault(name = "ParseException", targetNamespace = "http://controller.restful.home.com/")
public class ParseException_Exception extends Exception {

    private com.home.restful.controller.ParseException faultInfo;

    public ParseException_Exception() {
        super();
    }

    public ParseException_Exception(String message) {
        super(message);
    }

    public ParseException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ParseException_Exception(String message, com.home.restful.controller.ParseException parseException) {
        super(message);
        this.faultInfo = parseException;
    }

    public ParseException_Exception(String message, com.home.restful.controller.ParseException parseException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = parseException;
    }

    public com.home.restful.controller.ParseException getFaultInfo() {
        return this.faultInfo;
    }
}
