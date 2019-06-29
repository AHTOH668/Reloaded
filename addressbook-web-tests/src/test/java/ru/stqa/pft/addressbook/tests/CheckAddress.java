package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class CheckAddress extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().all().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("Антон").withLastName("Подд")
                    .withAddress("Street").withEmail("123@mail.com")
                    .withHome("888").withMobile("111").withWork("222"));
        }
    }

    @Test
    public void testAddressModification() {
        addressData contact = app.contact().all().iterator().next();
        addressData contactInfoFromEditForm = app.contact().infoFromEditFrom(contact);
        assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
    }

    private String mergeAddress(addressData contact) {
        return contact.getAddress();
    }

}
