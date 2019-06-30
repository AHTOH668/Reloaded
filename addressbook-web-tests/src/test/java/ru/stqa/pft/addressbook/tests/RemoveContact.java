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
        if (app.dbc().contacts().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("Антон").withLastName("Подд"));
        }
    }

    @Test
    public void testRemoveContact () {
        Contacts before = app.dbc().contacts();
        addressData deletedContact = before.iterator().next();
        app.contact().remove(deletedContact);
        assertThat(app.contact().count(),equalTo(before.size() - 1));
        Contacts after = app.dbc().contacts();
        assertThat(after, equalTo(before.without(deletedContact)));
    }

}
