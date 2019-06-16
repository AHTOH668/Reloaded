package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;
import java.util.Comparator;
import java.util.List;

public class AddressModification extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().list().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("Антон").withLastName("Подд").withPhone("8(495)1234567").withEmail("123@mail.com"));
        }
    }

    @Test
    public void testAddressModification() {
        List<addressData> before = app.contact().list();
        int index = before.size() - 1;
        addressData contact = new addressData().withId(before.get(index).getId()).withFirstName("rey").withLastName("brad").withPhone("795").withEmail("123@mail.ru");
        app.contact().modify(index, contact);
        List<addressData> after = app.contact().list();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super addressData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
