package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class addNewAddress extends TestBase {

  @Test
  public void testAddNewUser() throws Exception {
    goToNewAddress();
    fillAddressForm(new addressData("Антон", "Подд", "8(495)1234567", "123@mail.com"));
    submitNewAddress();
  }

}
