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
        if (app.contact().all().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("РђРЅС‚РѕРЅ").withLastName("РџРѕРґРґ"));
        }
    }

    @Test
    public void testAddressModification() {
        Contacts before = app.contact().all();
        addressData modifyContact = before.iterator().next();
        addressData contact = new addressData()
                .withId(modifyContact.getId()).withFirstName("rey").withLastName("brad");
        app.contact().modify(contact);
        assertThat(app.contact().count(),equalTo(before.size()));

        addressData contactInfoFromEditForm = app.contact().infoFromEditFrom(contact);
        assertThat(contact.getFirstName(), equalTo(mergeFirstName(contactInfoFromEditForm)));
        assertThat(contact.getLastName(), equalTo(mergeLastName(contactInfoFromEditForm)));
    }

    private String mergeFirstName(addressData contact) {
        return contact.getFirstName();
    }

    private String mergeLastName(addressData contact) {
        return contact.getLastName();
    }


}
