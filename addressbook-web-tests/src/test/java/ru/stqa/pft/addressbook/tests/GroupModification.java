package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.contactData;

import java.util.List;

public class GroupModification extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroup();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new contactData("test1", "test1", "test1"));
        }
        List<contactData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification ();
        app.getGroupHelper().fillGroupForm(new contactData("1test", "2test", "3test"));
        app.getGroupHelper().submitGroupModification ();
        app.getGroupHelper().returnToGroupPage();
        List<contactData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());

    }
}
