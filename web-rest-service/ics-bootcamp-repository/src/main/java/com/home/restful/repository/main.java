package com.home.restful.repository;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.home.restful.entity.Insurance;
import com.home.restful.entity.Person;

public class main {
	
		public static void main(String[] args) throws ParseException {
			/*	PersonRepository personRep = new PersonRepository();
				Person person = new Person();
				person.setId(3);
				person.setFirstName("dina");
				//person.setLastName("ffff");
				//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				//person.setJoinedDate(formatter.parse("19/06/1999"));
				personRep.deletePerson(person);
				//System.out.println(insurance.getId());
*/
			InsuranceRepository insRep = new InsuranceRepository();
			Insurance insurance  = new Insurance();
			
			
			Set<Entry<Integer, Insurance>> set=insRep.getInsurance().entrySet();//Converting to Set so that we can traverse  
		    Iterator<Entry<Integer, Insurance>> itr=set.iterator();  
		    while(itr.hasNext()){  
		        //Converting to Map.Entry so that we can get key and value separately  
		        Map.Entry<Integer, Insurance> entry=(Entry<Integer, Insurance>)itr.next();  
		        System.out.println(entry.getKey()+" "+entry.getValue());  
		    }  
		
		}
}