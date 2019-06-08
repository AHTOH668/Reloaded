package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

import java.util.List;

public class RemoveContact extends TestBase {

    @Test
    public void testRemoveContact () {
        app.getNavigationHelper().goToHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToNewAddress();
            app.getContactHelper().createContact(new addressData("Антон", "Подд", "8(495)1234567", "123@mail.com"));
        }
        List<addressData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        List<addressData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size(), after.size() + 1); //why is it PASS????????
    }
}
