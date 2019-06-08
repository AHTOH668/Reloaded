package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

public class AddressModification extends TestBase {

    @Test
    public void testAddressModification() {
        app.getNavigationHelper().goToHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToNewAddress();
            app.getContactHelper().createContact(new addressData("Антон", "Подд", "8(495)1234567", "123@mail.com"));
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initAddressModification();
        app.getContactHelper().fillAddressForm (new addressData("rey", "brad", "795", "123@mail.ru"));
        app.getContactHelper().submitAddressModification ();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(before, after); //why is it PASS????????
    }
}
