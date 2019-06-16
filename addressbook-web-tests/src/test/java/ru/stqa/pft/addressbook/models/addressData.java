package ru.stqa.pft.addressbook.models;

import java.util.Objects;

public class addressData {
    private int id = Integer.MAX_VALUE;;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
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

    public addressData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public addressData withEmail(String email) {
        this.email = email;
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
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

}
