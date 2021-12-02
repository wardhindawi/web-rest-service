package com.home.restful.service;

import java.text.ParseException;
import java.util.Map;

import com.home.restful.entity.Insurance;
import com.home.restful.exception.DataNotFoundException;
import com.home.restful.repository.InsuranceRepository;

/**
 * This class is serviceImpl class. Normally this class should implement service interface and implement the
 * methods of interface
 *
 * @author preetham
 */
public class InsuranceService {

    private InsuranceRepository repository = new InsuranceRepository();

    public InsuranceService() {
        System.out.println("Insurance service called");
    }

    public Map<Integer, Insurance> getAllInsurances() {

        return repository.getInsurance();

    }

    public Insurance getInsurance(int Insuranceid) {
        Insurance insurance = new Insurance();
        insurance.setId(Insuranceid);
        insurance = repository.getInsurances(insurance);
        if (insurance == null) {
            throw new DataNotFoundException("Insurance with id " + Insuranceid + " not found");
        }

        return insurance;
    }

    public Insurance addInsurance(int personId, Insurance insurance) throws ParseException {
        return repository.addInsurance(insurance);
    }

    public void deleteInsurance(int insuranceId) {
        Insurance insurance = new Insurance();
        insurance.setId(insuranceId);
        repository.deleteInsurance(insurance);

    }

    public Insurance updateInsurance(int insuranceId, Insurance insurance) {
        // Person person = new Person();
        insurance.setId(insuranceId);
        Insurance tempInsurance = new Insurance();
        tempInsurance.setId(insuranceId);
        repository.getInsurances(tempInsurance);
        System.out.println(tempInsurance);
        if (tempInsurance != null) {
            try {
                insurance = repository.updateInsurance(insuranceId, insurance);
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        return insurance;

    }
}
