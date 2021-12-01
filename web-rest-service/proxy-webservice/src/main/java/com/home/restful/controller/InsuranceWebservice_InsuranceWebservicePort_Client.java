
package com.home.restful.controller;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.5
 * 2021-12-01T09:04:55.550+02:00
 * Generated source version: 3.4.5
 *
 */
public final class InsuranceWebservice_InsuranceWebservicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://controller.restful.home.com/", "Insurances-ws");

    private InsuranceWebservice_InsuranceWebservicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = InsurancesWs.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        InsurancesWs ss = new InsurancesWs(wsdlURL, SERVICE_NAME);
        InsuranceWebservice port = ss.getInsuranceWebservicePort();

        {
        System.out.println("Invoking deleteInsurance...");
        int _deleteInsurance_arg0 = 0;
        port.deleteInsurance(_deleteInsurance_arg0);


        }
        {
        System.out.println("Invoking getInsurances...");
        com.home.restful.controller.GetInsurancesResponse.Return _getInsurances__return = port.getInsurances();
        System.out.println("getInsurances.result=" + _getInsurances__return);


        }
        {
        System.out.println("Invoking getInsurance...");
        int _getInsurance_arg0 = 0;
        com.home.restful.controller.Insurance _getInsurance__return = port.getInsurance(_getInsurance_arg0);
        System.out.println("getInsurance.result=" + _getInsurance__return);


        }
        {
        System.out.println("Invoking updateInsurance...");
        int _updateInsurance_arg0 = 0;
        com.home.restful.controller.Insurance _updateInsurance_arg1 = null;
        try {
            com.home.restful.controller.Insurance _updateInsurance__return = port.updateInsurance(_updateInsurance_arg0, _updateInsurance_arg1);
            System.out.println("updateInsurance.result=" + _updateInsurance__return);

        } catch (ParseException_Exception e) {
            System.out.println("Expected exception: ParseException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking addInsurance...");
        com.home.restful.controller.Insurance _addInsurance_arg0 = null;
        int _addInsurance_arg1 = 0;
        try {
            com.home.restful.controller.Insurance _addInsurance__return = port.addInsurance(_addInsurance_arg0, _addInsurance_arg1);
            System.out.println("addInsurance.result=" + _addInsurance__return);

        } catch (ParseException_Exception e) {
            System.out.println("Expected exception: ParseException has occurred.");
            System.out.println(e.toString());
        }

            }

        System.exit(0);
    }

}
