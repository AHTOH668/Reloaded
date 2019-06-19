package ru.stqa.pft.addressbook.models;

import java.util.Objects;

public class addressData {
    private int id = Integer.MAX_VALUE;;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String home;
    private String mobile;
    private String work;



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

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public addressData withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        addressData that = (addressData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(home, that.home) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(work, that.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, home, mobile, work);
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

    @Override
    public String toString() {
        return "addressData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", home='" + home + '\'' +
                ", mobile='" + mobile + '\'' +
                ", work='" + work + '\'' +
                '}';
    }

}
