package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.models.groupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class RemoveGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new groupData().withName("test1"));
    }
  }

  @Test
  public void testRemoveGroup() {
    Groups before = app.group().all();
    groupData deletedGroup = before.iterator().next();
    app.group().remove(deletedGroup);
    Groups after = app.group().all();
    assertEquals(after.size(),before.size() - 1);

    assertThat(after, equalTo(before.without(deletedGroup)));
  }

}
