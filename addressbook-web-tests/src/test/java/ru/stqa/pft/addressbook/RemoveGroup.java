package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class RemoveGroup extends TestBase{

  @Test
  public void testRemoveGroup() {
    gotoGroup();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }


}
