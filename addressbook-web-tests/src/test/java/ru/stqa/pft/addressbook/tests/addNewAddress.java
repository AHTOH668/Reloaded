package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.addressData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class addNewAddress extends TestBase {

  @Test
  public void testAddNewUser() {
    Contacts before = app.contact().all();
    app.goTo().newAddress();
    addressData contact = new addressData().withFirstName("Антон").withLastName("Подд").withPhone("8(495)1234567").withEmail("123@mail.com");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1)); //why is it PASS????????

    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
