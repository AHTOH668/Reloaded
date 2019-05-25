package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.groupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroup();
    app.groupCreation();
    app.fillGroupForm(new groupData("test1", "test1", "test1"));
    app.submitGroupCreation();
    app.returnToGroupPage();

  }


}
