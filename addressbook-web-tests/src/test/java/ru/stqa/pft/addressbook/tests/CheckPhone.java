package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class CheckPhone extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().all().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("Антон").withLastName("Подд").withHome("8(495)1234567").withEmail("123@mail.com").withMobile("111").withWork("222"));
        }
    }

    @Test
    public void checkPhones () {
        app.goTo().home();
        addressData contact = app.contact().all().iterator().next();
        addressData contactInformation = app.contact().contactInformation(contact);

        assertThat(contact.getHome(), equalTo(contactInformation.getHome()));
        assertThat(contact.getMobile(), equalTo(contactInformation.getMobile()));
        assertThat(contact.getWork(), equalTo(contactInformation.getWork()));
    }

}
