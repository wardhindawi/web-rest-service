package com.home.restful.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.home.restful.model.Link;

/**
 * @author preetham
 */
@XmlRootElement
public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private Date joinedDate;
    private Map<Integer, Insurance> insurances = new HashMap<Integer, Insurance>();
    private List<Link> links = new ArrayList<Link>();

    public Person() {
        System.out.println("Person constructor called");
    }

    public Person(int id, String firstName, String lastName) {
        System.out.println("Person parmaterized constructor called");
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinedDate = new Date();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date dob) {
        this.joinedDate = dob;
    }

    // Person response will not contain the insurance resources
    @XmlTransient
    public Map<Integer, Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(Map<Integer, Insurance> insurances) {
        this.insurances = insurances;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(String url, String rel) {
        Link link = new Link(url, rel);
        if (!links.contains(link)) {
            links.add(link);
        }
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + joinedDate
                + ", insurances=" + insurances + ", links=" + links + "]";
    }

}
