package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

import java.util.List;

public class AddressModification extends TestBase {

    @Test
    public void testAddressModification() {
        app.getNavigationHelper().goToHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToNewAddress();
            app.getContactHelper().createContact(new addressData("Антон", "Подд", "8(495)1234567", "123@mail.com"));
        }
        List<addressData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initAddressModification(before.size() - 1);
        app.getContactHelper().fillAddressForm (new addressData("rey", "brad", "795", "123@mail.ru"));
        app.getContactHelper().submitAddressModification ();
        List<addressData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size(), after.size()); //why is it PASS????????
    }
}
