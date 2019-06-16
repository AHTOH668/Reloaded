package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.groupData;
import java.util.List;

public class RemoveGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new groupData().withName("test1"));
    }
  }

  @Test
  public void testRemoveGroup() {
    List<groupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().remove(index);
    List<groupData> after = app.group().list();
    Assert.assertEquals(after.size(),before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
