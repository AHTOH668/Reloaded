package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

public class addNewAddress extends TestBase {

  @Test
  public void testAddNewUser() {
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().goToNewAddress();
    app.getContactHelper().createContact(new addressData("Антон", "Подд", "8(495)1234567", "123@mail.com"));
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(before, after - 1); //why is it PASS????????
  }

}
