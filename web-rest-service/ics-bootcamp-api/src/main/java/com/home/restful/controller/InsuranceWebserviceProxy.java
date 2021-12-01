package com.home.restful.controller;

public class InsuranceWebserviceProxy implements com.home.restful.controller.InsuranceWebservice {
  private String _endpoint = null;
  private com.home.restful.controller.InsuranceWebservice insuranceWebservice = null;
  
  public InsuranceWebserviceProxy() {
    _initInsuranceWebserviceProxy();
  }
  
  public InsuranceWebserviceProxy(String endpoint) {
    _endpoint = endpoint;
    _initInsuranceWebserviceProxy();
  }
  
  private void _initInsuranceWebserviceProxy() {
    try {
      insuranceWebservice = (new com.home.restful.controller.InsurancesWsLocator()).getInsuranceWebservicePort();
      if (insuranceWebservice != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)insuranceWebservice)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)insuranceWebservice)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (insuranceWebservice != null)
      ((javax.xml.rpc.Stub)insuranceWebservice)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.home.restful.controller.InsuranceWebservice getInsuranceWebservice() {
    if (insuranceWebservice == null)
      _initInsuranceWebserviceProxy();
    return insuranceWebservice;
  }
  
  public void deleteInsurance(int arg0) throws java.rmi.RemoteException{
    if (insuranceWebservice == null)
      _initInsuranceWebserviceProxy();
    insuranceWebservice.deleteInsurance(arg0);
  }
  
  public com.home.restful.controller.GetInsurancesResponse_returnEntry[] getInsurances() throws java.rmi.RemoteException{
    if (insuranceWebservice == null)
      _initInsuranceWebserviceProxy();
    return insuranceWebservice.getInsurances();
  }
  
  public com.home.restful.controller.Insurance getInsurance(int arg0) throws java.rmi.RemoteException{
    if (insuranceWebservice == null)
      _initInsuranceWebserviceProxy();
    return insuranceWebservice.getInsurance(arg0);
  }
  
  public com.home.restful.controller.Insurance updateInsurance(int arg0, com.home.restful.controller.Insurance arg1) throws java.rmi.RemoteException, com.home.restful.controller.ParseException{
    if (insuranceWebservice == null)
      _initInsuranceWebserviceProxy();
    return insuranceWebservice.updateInsurance(arg0, arg1);
  }
  
  public com.home.restful.controller.Insurance addInsurance(com.home.restful.controller.Insurance arg0, int arg1) throws java.rmi.RemoteException, com.home.restful.controller.ParseException{
    if (insuranceWebservice == null)
      _initInsuranceWebserviceProxy();
    return insuranceWebservice.addInsurance(arg0, arg1);
  }
  
  
}