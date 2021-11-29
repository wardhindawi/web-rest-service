package com.home.restful.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.home.restful.entity.Insurance;

public class mainTest {
    public static void main(String[] args) throws ParseException {
        InsuranceService insRep = new InsuranceService();
        Insurance insurance = new Insurance();
        // Person person = new Person();
        // PersonService perSer = new PersonService();

        String sDate1 = "11/18/2021";
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        insurance.setCreatedDate(date1);

        /* person.setId(7);
         * person.setFirstName("ward");
         * person.setLastName("Hindawi");
         * person.setJoinedDate(date1);
         * perSer.addPerson(person); */
        /*****************
         * insRep.addInsurance(insurance.getId(), insurance);
         **************/
        /*******************************/

        insurance.setId(7);
        insurance.setName("test name");
        insRep.updateInsurance(insurance.getId(), insurance);
        /*******************************/
        Set<Entry<Integer, Insurance>> set = insRep.getAllInsurances().entrySet();// Converting to Set so that
                                                                                  // we can traverse
        Iterator<Entry<Integer, Insurance>> itr = set.iterator();
        while (itr.hasNext()) {
            // Converting to Map.Entry so that we can get key and value separately
            Map.Entry<Integer, Insurance> entry = itr.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        /******************************/
    }
}
