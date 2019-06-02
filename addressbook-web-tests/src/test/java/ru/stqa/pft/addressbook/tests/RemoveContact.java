package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

public class RemoveContact extends TestBase {

    @Test
    public void testRemoveContact () {
        app.getNavigationHelper().goToHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToNewAddress();
            app.getContactHelper().createContact(new addressData("Антон", "Подд", "8(495)1234567", "123@mail.com"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
    }
}
