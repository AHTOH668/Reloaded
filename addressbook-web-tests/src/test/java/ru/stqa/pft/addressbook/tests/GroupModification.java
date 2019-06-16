package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.models.groupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


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
        Groups before = app.group().all();
        groupData modifyGroup = before.iterator().next();
        groupData group = new groupData().withId(modifyGroup.getId()).withName("1test").withHeader("2test").withFooter("3test");
        app.group().modify(group);
        Groups after = app.group().all();
        assertEquals(after.size(),before.size());

        assertThat(after, equalTo(before.without(modifyGroup).withAdded(group)));
    }



}
