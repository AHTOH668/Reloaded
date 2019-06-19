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
            app.contact().create(new addressData().withFirstName("Антон").withLastName("Подд")
                    .withHome("8(495)1234567").withEmail("123@mail.com").withHome("795").withEmail("123@mail.ru")
                    .withHome("888").withMobile("111").withWork("222"));
        }
    }

    @Test
    public void testAddressModification() {
        addressData contact = app.contact().all().iterator().next();
        addressData contactInfoFromEditForm = app.contact().infoFromEditFrom(contact);

        assertThat(contact.getHome(), equalTo(cleaned(contactInfoFromEditForm.getHome())));
        assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFromEditForm.getMobile())));
        assertThat(contact.getWork(), equalTo(cleaned(contactInfoFromEditForm.getWork())));
    }

    public String cleaned(String phone) {
        return phone.replace("\\s","").replaceAll("[-()]","");
    }

}
