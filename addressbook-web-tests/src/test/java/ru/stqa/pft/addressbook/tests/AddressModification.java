package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.addressData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class AddressModification extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().all().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("Антон").withLastName("Подд").withPhone("8(495)1234567").withEmail("123@mail.com"));
        }
    }

    @Test
    public void testAddressModification() {
        Contacts before = app.contact().all();
        addressData modifyContact = before.iterator().next();
        addressData contact = new addressData().withId(modifyContact.getId()).withFirstName("rey").withLastName("brad").withPhone("795").withEmail("123@mail.ru");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertEquals(before.size(), after.size());

        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
    }

}
