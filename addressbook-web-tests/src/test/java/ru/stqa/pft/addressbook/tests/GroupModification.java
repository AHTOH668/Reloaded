package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.groupData;

import java.util.Comparator;
import java.util.List;

public class GroupModification extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroup();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new groupData("test1", "test1", "test1"));
        }
        List<groupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification ();
        groupData group = new groupData(before.get(before.size() - 1).getId(), "1test", "2test", "3test");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification ();
        app.getGroupHelper().returnToGroupPage();
        List<groupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Comparator<? super groupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}
