package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.groupData;

public class GroupModification extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroup();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new groupData("test1", "test1", "test1"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification ();
        app.getGroupHelper().fillGroupForm(new groupData("1test", "2test", "3test"));
        app.getGroupHelper().submitGroupModification ();
        app.getGroupHelper().returnToGroupPage();

    }
}
