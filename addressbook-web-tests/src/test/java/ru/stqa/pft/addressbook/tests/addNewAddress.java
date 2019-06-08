package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

import java.util.List;

public class addNewAddress extends TestBase {

  @Test
  public void testAddNewUser() {
    List<addressData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().goToNewAddress();
    app.getContactHelper().createContact(new addressData("Антон", "Подд", "8(495)1234567", "123@mail.com"));
    List<addressData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size() - 1); //why is it PASS????????
  }

}
