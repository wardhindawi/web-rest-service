package com.home.restful.service;

import java.util.List;

import com.home.restful.entity.Insurance;
import com.home.restful.entity.Person;
import com.home.restful.exception.DataNotFoundException;
import com.home.restful.repository.InsuranceRepository;
import com.home.restful.repository.PersonRepository;

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

    public List<Insurance> getAllInsurances(long personId) {

        return repository.getInsurances(personId);

    }

    public Insurance getInsurance(long personId, long insuranceId) {
        Insurance insurance = repository.getInsurance(personId, insuranceId);
        if (insurance == null) {
            throw new DataNotFoundException("Insurance with id " + insuranceId + " not found");
        }
        return insurance;
    }

    public Insurance addInsurance(long personId, Insurance insurance) {
        return repository.addInsurance(personId, insurance);
    }

    public void deleteInsurance(long personId, long insuranceId) {
        repository.deleteInsurance(personId, insuranceId);

    }

    public Insurance updateInsurance(long personId, Insurance insurance) {
        Person tempPerson = new PersonRepository().getPerson(personId);
        if (tempPerson != null && tempPerson.getInsurances().get(insurance.getId()) != null) {
            Insurance tempInsurance = tempPerson.getInsurances().get(insurance.getId());
            insurance.setCreatedDate(tempInsurance.getCreatedDate());
            return repository.updateInsurance(personId, insurance);
        } else {
            throw new DataNotFoundException("Person with id " + tempPerson.getId() + " not found");

        }
    }
}
