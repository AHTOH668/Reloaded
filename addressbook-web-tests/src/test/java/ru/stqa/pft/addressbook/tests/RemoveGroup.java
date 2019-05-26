package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class RemoveGroup extends TestBase {

  @Test
  public void testRemoveGroup() {
    app.getNavigationHelper().gotoGroup();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }


}
