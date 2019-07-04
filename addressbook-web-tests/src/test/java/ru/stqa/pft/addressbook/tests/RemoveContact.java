package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.addressData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class RemoveContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().all().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("РђРЅС‚РѕРЅ").withLastName("РџРѕРґРґ"));
        }
    }

    @Test
    public void testRemoveContact () {
        Contacts before = app.contact().all();
        addressData deletedContact = before.iterator().next();
        app.contact().remove(deletedContact);
        assertThat(app.contact().count(),equalTo(before.size() - 1));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(before.without(deletedContact)));
    }

}
