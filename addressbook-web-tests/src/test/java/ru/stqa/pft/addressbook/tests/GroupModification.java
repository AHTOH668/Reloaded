package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.groupData;
import java.util.Comparator;
import java.util.List;

public class GroupModification extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroup();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new groupData("test1", "test1", "test1"));
        }
    }

    @Test
    public void testGroupModification() {
        List<groupData> before = app.getGroupHelper().getGroupList();
        int index = before.size() - 1;
        groupData group = new groupData(before.get(index).getId(), "1test", "2test", "3test");
        app.getGroupHelper().modifyGroup(index, group);
        List<groupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super groupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }



}
