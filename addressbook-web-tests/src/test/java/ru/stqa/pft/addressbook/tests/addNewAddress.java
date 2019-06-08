package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

import java.util.Comparator;
import java.util.List;

public class addNewAddress extends TestBase {

  @Test
  public void testAddNewUser() {
    List<addressData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().goToNewAddress();
    addressData contact = new addressData("Антон", "Подд", "8(495)1234567", "123@mail.com");
    app.getContactHelper().createContact(contact);
    List<addressData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size() - 1); //why is it PASS????????

    before.add(contact);
    Comparator<? super addressData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
