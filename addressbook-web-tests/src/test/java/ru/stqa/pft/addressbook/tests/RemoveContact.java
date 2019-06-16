package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.addressData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class RemoveContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().all().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("Антон").withLastName("Подд"));
        }
    }

    @Test
    public void testRemoveContact () {
        Contacts before = app.contact().all();
        addressData deletedContact = before.iterator().next();
        app.contact().remove(deletedContact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() - 1); //why is it PASS????????

        assertThat(after, equalTo(before.without(deletedContact)));
    }

}
