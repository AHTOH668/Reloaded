package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

import java.util.Set;

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
        Set<addressData> before = app.contact().all();
        addressData modifyContact = before.iterator().next();
        addressData contact = new addressData().withId(modifyContact.getId()).withFirstName("rey").withLastName("brad").withPhone("795").withEmail("123@mail.ru");
        app.contact().modify(contact);
        Set<addressData> after = app.contact().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(modifyContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}
