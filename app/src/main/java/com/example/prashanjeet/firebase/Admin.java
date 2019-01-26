package com.example.prashanjeet.firebase;

/**
 * Created by Mayank on 26-01-2019.
 */

public class Admin {

    private String companyName,companyDomain,name,email,password,contact,lati,longi;
    private String id;

    public Admin(){

    }



    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    public Admin(String companyName, String companyDomain, String name, String email, String password, String contact, String id, String lati, String longi) {
        this.companyName=companyName;
        this.companyDomain=companyDomain;
        this.name = name;
        this.email = email;
        this.password=password;
        this.contact=contact;

        this.id=id;
        this.lati = lati;
        this.longi=longi;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setComapanyName(String name) {
        this.companyName = name;
    }

    public String getCompanyDomain() {
        return companyDomain;
    }

    public void setCompanyDomain(String name) {
        this.companyDomain = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
