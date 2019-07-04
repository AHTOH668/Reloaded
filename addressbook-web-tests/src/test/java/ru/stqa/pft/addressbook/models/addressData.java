package ru.stqa.pft.addressbook.models;

import com.google.gson.annotations.Expose;
import java.util.Objects;

public class addressData {
    private int id = Integer.MAX_VALUE;
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    private String address;
    private String email;
    private String email2;
    private String email3;
    private String home;
    private String mobile;
    private String work;
    private String allPhones;
    private String allEmails;


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public addressData withId(int id) {
        this.id = id;
        return this;
    }

    public addressData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public addressData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public addressData withAddress(String address) {
        this.address = address;
        return this;
    }

    public addressData withEmail(String email) {
        this.email = email;
        return this;
    }

    public addressData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public addressData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public addressData withHome(String home) {
        this.home = home;
        return this;
    }

    public addressData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public addressData withWork(String work) {
        this.work = work;
        return this;
    }

    public addressData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public addressData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    @Override
    public String toString() {
        return "addressData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        addressData that = (addressData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

}
