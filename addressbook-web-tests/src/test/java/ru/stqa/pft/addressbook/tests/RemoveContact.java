package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class RemoveContact extends TestBase {

    @Test
    public void testRemoveContact () {
        app.getNavigationHelper().goToHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
    }
}
