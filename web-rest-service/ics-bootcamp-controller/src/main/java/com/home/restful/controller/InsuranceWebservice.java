package com.home.restful.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;

import com.home.restful.entity.Insurance;
import com.home.restful.service.InsuranceService;

@WebService (serviceName = "Insurances-ws")
public class InsuranceWebservice {
    private InsuranceService service = new InsuranceService();

    @WebMethod
    public Insurance getInsurance(//
            @PathParam ("InsuranceId")
            int id) {
        Insurance Insurance = service.getInsurance(id);
        // Insurance.addLink(getUriForSelf(Insurance, uriInfo), "self");
        // Insurance.addLink(getUriForInsurance(Insurance, uriInfo), "insurance");
        return Insurance;

    }

    @WebMethod
    public Map<Integer, Insurance> getInsurances() {

        Map<Integer, Insurance> Insurances = service.getAllInsurances();
        for (Entry<Integer, Insurance> entry : Insurances.entrySet()) {
            System.out.println("Key:" + entry.getKey() + " " + entry.getValue());

            // entry.getValue().addLink(getUriForSelf(entry.getValue(), uriInfo), "self");

            // entry.getValue().addLink(getUriForInsurance(entry.getValue(), uriInfo), "insurance");

        }

        System.out.println(Insurances);
        GenericEntity<Map<Integer, Insurance>> entity = new GenericEntity<Map<Integer, Insurance>>(Insurances) {
        };
        return Insurances;
    }

    @WebMethod
    public Insurance addInsurance(Insurance insurance, int id) throws ParseException {
        insurance.setCreatedDate(new Date());
        Insurance newInsurance = service.addInsurance(id, insurance);
        // URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(newInsurance.getId())).build();

        // newInsurance.addLink(getUriForSelf(newInsurance, uriInfo), "self");
        // newInsurance.addLink(getUriForInsurance(newInsurance, uriInfo), "insurance");

        return insurance;
    }

    @WebMethod
    public Insurance updateInsurance(@PathParam ("InsuranceId")
    int id, Insurance insurance) throws ParseException {
        insurance.setId(id);
        service.updateInsurance(id, insurance);
        return insurance;
    }

    @WebMethod
    public void deleteInsurance(@PathParam ("InsuranceId")
    int id) {
        service.deleteInsurance(id);
    }
}
