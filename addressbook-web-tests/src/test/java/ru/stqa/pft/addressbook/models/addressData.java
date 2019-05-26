package ru.stqa.pft.addressbook.models;

public class addressData {
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String email;

    public addressData(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
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
}
