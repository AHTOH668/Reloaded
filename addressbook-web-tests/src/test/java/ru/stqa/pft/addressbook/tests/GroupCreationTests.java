package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.groupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    int before = app.getGroupHelper().getGroupCount();
    app.getNavigationHelper().gotoGroup();
    app.getGroupHelper().createGroup(new groupData("test1", "test1", "test1"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before + 1);

  }


}
