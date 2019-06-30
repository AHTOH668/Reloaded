package ru.stqa.pft.addressbook.models;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "group_list")
public class groupData {
    @Id
    @Column(name = "group_id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "group_name")
    private String name;
    @Expose
    @Column(name = "group_header")
    private String header;
    @Expose
    @Column(name = "group_footer")
    @Type(type = "test")
    private String footer;

    @ManyToMany (mappedBy = "groups")
    private Set<addressData> contacts = new HashSet<addressData>();

        public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public groupData withId(int id) {
        this.id = id;
        return this;
    }

    public groupData withName(String name) {
        this.name = name;
        return this;
    }

    public groupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public groupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public Contacts getContacts() {
        return new Contacts(contacts);
    }

    @Override
    public String toString() {
        return "groupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        groupData groupData = (groupData) o;
        return id == groupData.id &&
                Objects.equals(name, groupData.name) &&
                Objects.equals(header, groupData.header) &&
                Objects.equals(footer, groupData.footer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, header, footer);
    }

}
