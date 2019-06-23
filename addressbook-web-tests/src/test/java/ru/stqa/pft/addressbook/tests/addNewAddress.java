package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.addressData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class addNewAddress extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new addressData().withFirstName("Антон1").withLastName("Подд1").
            withHome("111").withEmail("111@mail.com")});
    list.add(new Object[] {new addressData().withFirstName("Антон2").withLastName("Подд2").
            withHome("222").withEmail("222@mail.com")});
    list.add(new Object[] {new addressData().withFirstName("Антон3").withLastName("Подд3").
            withHome("333").withEmail("333@mail.com")});
    return list.iterator();
  }

  @Test (dataProvider = "validGroups")
  public void testAddNewUser(addressData contact) {
    app.goTo().newAddress();
    Contacts before = app.contact().all();
    app.contact().create(contact);
    assertThat(app.contact().count(),equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
