package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

import java.util.Set;

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
        Set<addressData> before = app.contact().all();
        addressData deletedContact = before.iterator().next();
        app.contact().remove(deletedContact);
        Set<addressData> after = app.contact().all();
        Assert.assertEquals(before.size(), after.size() + 1); //why is it PASS????????

        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }

}
