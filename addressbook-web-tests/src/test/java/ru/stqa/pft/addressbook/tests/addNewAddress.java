package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;
import java.util.HashSet;
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


    int max = 0;
    for (addressData g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }


    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
