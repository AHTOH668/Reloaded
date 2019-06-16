package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.addressData;
import java.util.List;

public class RemoveContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().list().size() == 0) {
            app.goTo().newAddress();
            app.contact().create(new addressData().withFirstName("Антон").withLastName("Подд"));
        }
    }

    @Test
    public void testRemoveContact () {
        List<addressData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().remove(index);
        List<addressData> after = app.contact().list();
        Assert.assertEquals(before.size(), after.size() + 1); //why is it PASS????????

        before.remove(index);
        Assert.assertEquals(before, after);
    }

}
