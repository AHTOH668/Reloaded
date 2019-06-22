package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.addressData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddressModification extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().all().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("Антон").withLastName("Подд"));
        }
    }

    @Test
    public void testAddressModification() {
        Contacts before = app.contact().all();
        addressData modifyContact = before.iterator().next();
        addressData contact = new addressData().withId(modifyContact.getId()).withFirstName("rey").withLastName("brad")
                .withHome("795").withEmail("123@mail.ru");
        app.contact().modify(contact);
        assertThat(app.contact().count(),equalTo(before.size()));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
    }

}
