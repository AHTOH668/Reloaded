package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.contactData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroup();
    List <contactData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new contactData("test1", "test1", "test1"));
    List <contactData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size() + 1);

  }


}
