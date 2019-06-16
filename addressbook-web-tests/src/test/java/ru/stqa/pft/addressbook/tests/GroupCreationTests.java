package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.groupData;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    List <groupData> before = app.group().list();
    groupData group = new groupData().withName("test1").withFooter("test2").withHeader("test3");
    app.group().create(group);
    List <groupData> after = app.group().list();
    Assert.assertEquals(after.size(),before.size() + 1);

    before.add(group);
    Comparator<? super groupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
