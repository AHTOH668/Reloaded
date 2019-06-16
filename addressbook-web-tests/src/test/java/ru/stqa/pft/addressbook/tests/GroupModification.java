package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.groupData;

import java.util.Set;

public class GroupModification extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new groupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        Set<groupData> before = app.group().all();
        groupData modifyGroup = before.iterator().next();
        groupData group = new groupData().withId(modifyGroup.getId()).withName("1test").withHeader("2test").withFooter("3test");
        app.group().modify(group);
        Set<groupData> after = app.group().all();
        Assert.assertEquals(after.size(),before.size());

        before.remove(modifyGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }



}
