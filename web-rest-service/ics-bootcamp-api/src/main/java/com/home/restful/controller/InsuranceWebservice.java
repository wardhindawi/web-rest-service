/**
 * InsuranceWebservice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.home.restful.controller;

public interface InsuranceWebservice extends java.rmi.Remote {
    public void deleteInsurance(int arg0) throws java.rmi.RemoteException;
    public com.home.restful.controller.GetInsurancesResponse_returnEntry[] getInsurances() throws java.rmi.RemoteException;
    public com.home.restful.controller.Insurance getInsurance(int arg0) throws java.rmi.RemoteException;
    public com.home.restful.controller.Insurance updateInsurance(int arg0, com.home.restful.controller.Insurance arg1) throws java.rmi.RemoteException, com.home.restful.controller.ParseException;
    public com.home.restful.controller.Insurance addInsurance(com.home.restful.controller.Insurance arg0, int arg1) throws java.rmi.RemoteException, com.home.restful.controller.ParseException;
}
