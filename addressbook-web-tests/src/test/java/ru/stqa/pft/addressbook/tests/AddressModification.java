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
        app.getNavigationHelper().goToHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToNewAddress();
            app.getContactHelper().createContact(new addressData("Антон", "Подд", "8(495)1234567", "123@mail.com"));
        }
    }

    @Test
    public void testAddressModification() {
        List<addressData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        addressData contact = new addressData(before.get(index).getId(),"rey", "brad", "795", "123@mail.ru");
        app.getContactHelper().modifyContact(index, contact);
        List<addressData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super addressData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
