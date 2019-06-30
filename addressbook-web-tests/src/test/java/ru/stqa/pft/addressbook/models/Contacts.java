package ru.stqa.pft.addressbook.models;

import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class Contacts extends ForwardingSet<addressData> {


    private Set<addressData> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<addressData>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<addressData>();
    }

    public Contacts(Collection<addressData> contacts) {
        this.delegate = new HashSet<addressData>(contacts);
    }

    public Contacts withAdded (addressData contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without (addressData contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }

    @Override
    protected Set<addressData> delegate() {
        return delegate;
    }
}
