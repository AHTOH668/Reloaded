package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;

import java.util.Arrays;
import java.util.stream.Collectors;

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

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(addressData contact) {
        return Arrays.asList(contact.getHome(),contact.getMobile(), contact.getWork())
                .stream().filter((s) -> ! s.equals(""))
                .map(CheckPhone::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replace("\\s","").replaceAll("[-()]","");
    }

}
