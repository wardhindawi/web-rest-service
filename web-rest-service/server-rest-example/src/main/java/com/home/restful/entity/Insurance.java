package com.home.restful.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.home.restful.model.Link;

/**
 * @author preetham
 */
@XmlRootElement
public class Insurance {

    private int id;
    private String name;
    private Date createdDate;
    private List<Link> links = new ArrayList<Link>();

    public Insurance() {

    }

    public Insurance(int id, String name) {
        this.id = id;
        this.name = name;
        this.createdDate = new Date();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
        return "Insurance [id=" + id + ", name=" + name + ", createdDate=" + createdDate + "]";
    }

}
