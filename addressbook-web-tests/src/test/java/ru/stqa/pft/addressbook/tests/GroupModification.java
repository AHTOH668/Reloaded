package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.models.groupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupModification extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new groupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.db().groups();
        groupData modifyGroup = before.iterator().next();
        groupData group = new groupData()
                .withId(modifyGroup.getId()).withName("1test").withHeader("2test").withFooter("3test");
        app.goTo().groupPage();
        app.group().modify(group);
        assertThat(app.group().count(),equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(modifyGroup).withAdded(group)));
        verifyGroupListInUI();
    }
}
