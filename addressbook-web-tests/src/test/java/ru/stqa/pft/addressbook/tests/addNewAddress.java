package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;
import java.util.Set;

public class addNewAddress extends TestBase {

  @Test
  public void testAddNewUser() {
    Set<addressData> before = app.contact().all();
    app.goTo().newAddress();
    addressData contact = new addressData().withFirstName("Антон").withLastName("Подд").withPhone("8(495)1234567").withEmail("123@mail.com");
    app.contact().create(contact);
    Set<addressData> after = app.contact().all();
    Assert.assertEquals(before.size(), after.size() - 1); //why is it PASS????????

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
