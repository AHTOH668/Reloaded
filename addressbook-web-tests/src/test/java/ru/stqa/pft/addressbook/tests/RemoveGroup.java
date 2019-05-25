package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class RemoveGroup extends TestBase {

  @Test
  public void testRemoveGroup() {
    app.gotoGroup();
    app.selectGroup();
    app.deleteSelectedGroups();
    app.returnToGroupPage();
  }


}
