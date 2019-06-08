package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;
import java.util.Comparator;
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
        addressData contact = new addressData(before.get(before.size() - 1).getId(),"rey", "brad", "795", "123@mail.ru");
        app.getContactHelper().fillAddressForm (contact);
        app.getContactHelper().submitAddressModification ();
        List<addressData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super addressData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
