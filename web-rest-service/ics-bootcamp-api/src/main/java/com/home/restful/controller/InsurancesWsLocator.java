/**
 * InsurancesWsLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.home.restful.controller;

public class InsurancesWsLocator extends org.apache.axis.client.Service implements com.home.restful.controller.InsurancesWs {

    public InsurancesWsLocator() {
    }


    public InsurancesWsLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public InsurancesWsLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for InsuranceWebservicePort
    private java.lang.String InsuranceWebservicePort_address = "http://localhost:8080/RESTfulWebServicesSample/Insurances-ws";

    public java.lang.String getInsuranceWebservicePortAddress() {
        return InsuranceWebservicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String InsuranceWebservicePortWSDDServiceName = "InsuranceWebservicePort";

    public java.lang.String getInsuranceWebservicePortWSDDServiceName() {
        return InsuranceWebservicePortWSDDServiceName;
    }

    public void setInsuranceWebservicePortWSDDServiceName(java.lang.String name) {
        InsuranceWebservicePortWSDDServiceName = name;
    }

    public com.home.restful.controller.InsuranceWebservice getInsuranceWebservicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(InsuranceWebservicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getInsuranceWebservicePort(endpoint);
    }

    public com.home.restful.controller.InsuranceWebservice getInsuranceWebservicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.home.restful.controller.InsurancesWsSoapBindingStub _stub = new com.home.restful.controller.InsurancesWsSoapBindingStub(portAddress, this);
            _stub.setPortName(getInsuranceWebservicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setInsuranceWebservicePortEndpointAddress(java.lang.String address) {
        InsuranceWebservicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.home.restful.controller.InsuranceWebservice.class.isAssignableFrom(serviceEndpointInterface)) {
                com.home.restful.controller.InsurancesWsSoapBindingStub _stub = new com.home.restful.controller.InsurancesWsSoapBindingStub(new java.net.URL(InsuranceWebservicePort_address), this);
                _stub.setPortName(getInsuranceWebservicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("InsuranceWebservicePort".equals(inputPortName)) {
            return getInsuranceWebservicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://controller.restful.home.com/", "Insurances-ws");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://controller.restful.home.com/", "InsuranceWebservicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("InsuranceWebservicePort".equals(portName)) {
            setInsuranceWebservicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
