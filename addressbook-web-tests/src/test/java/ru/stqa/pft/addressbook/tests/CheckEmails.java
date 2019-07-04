package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class CheckEmails extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().all().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("РђРЅС‚РѕРЅ").withLastName("РџРѕРґРґ")
                    .withAddress("Street").withEmail("123@mail.com")
                    .withHome("888").withMobile("111").withWork("222"));
        }
    }

    @Test
    public void testAddressModification() {
        addressData contact = app.contact().all().iterator().next();
        addressData contactInfoFromEditForm = app.contact().infoFromEditFrom(contact);
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergeEmails(addressData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }
}
