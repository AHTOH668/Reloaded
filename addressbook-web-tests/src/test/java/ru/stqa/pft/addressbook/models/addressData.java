package ru.stqa.pft.addressbook.models;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "addressbook")
public class addressData {

    @Id
    @Column (name = "id")
    private int id = Integer.MAX_VALUE;
    @Column (name = "firstname")
    private String firstName;
    @Column (name = "lastname")
    private String lastName;
    @Column (name = "address")
    private String address;
    @Column (name = "email")
    private String email;
    @Column (name = "email2")
    private String email2;
    @Column (name = "email3")
    private String email3;
    @Column (name = "home")
    @Type(type = "text")
    private String home;
    @Column (name = "mobile")
    @Type(type = "text")
    private String mobile;
    @Column (name = "work")
    @Type(type = "text")
    private String work;
    @Transient
    private String allPhones;
    @Transient
    private String allEmails;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<groupData> groups = new HashSet<groupData>();

    public File getPhoto () {
        return new File(photo);
    }

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

    public Groups getGroups() {
        return new Groups(groups);
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

    public addressData withPhoto(File photo) {
        this.photo = photo.getPath();
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
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(email, that.email) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(email3, that.email3) &&
                Objects.equals(home, that.home) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(work, that.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, email, email2, email3, home, mobile, work);
    }
}
