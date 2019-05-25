package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroup();
    groupCreation();
    fillGroupForm(new groupData("test1", "test1", "test1"));
    submitGroupCreation();
    returnToGroupPage();

  }


}
