package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.addressData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddressModification extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.dbc().contacts().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("Антон").withLastName("Подд"));
        }
    }

    @Test
    public void testAddressModification() {
        Contacts before = app.dbc().contacts();
        addressData modifyContact = before.iterator().next();
        addressData contact = new addressData()
                .withId(modifyContact.getId()).withFirstName("rey").withLastName("brad");
        app.contact().modify(contact);
        assertThat(app.contact().count(),equalTo(before.size()));
        Contacts after = app.dbc().contacts();
        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
    }

    private String mergeFirstName(addressData contact) {
        return contact.getFirstName();
    }

    private String mergeLastName(addressData contact) {
        return contact.getLastName();
    }


}
