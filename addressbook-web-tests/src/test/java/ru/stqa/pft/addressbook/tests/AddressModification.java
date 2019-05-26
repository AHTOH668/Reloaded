package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

public class AddressModification extends TestBase {

    @Test
    public void testAddressModification() {
        app.getNavigationHelper().goToHome();
        app.getContactHelper().initAddressModification ();
        app.getContactHelper().fillAddressForm (new addressData("rey", "brad", "795", "123@mail.ru"));
        app.getContactHelper().submitAddressModification ();
    }
}
