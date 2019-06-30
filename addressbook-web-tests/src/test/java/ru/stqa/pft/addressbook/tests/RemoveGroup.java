package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.models.groupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class RemoveGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new groupData().withName("test1"));
    }
  }

  @Test
  public void testRemoveGroup() {
    Groups before = app.db().groups();
    groupData deletedGroup = before.iterator().next();
    app.group().remove(deletedGroup);
    assertThat(app.group().count(),equalTo(before.size() - 1));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deletedGroup)));
    verifyGroupListInUI();
  }

}
