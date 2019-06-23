package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.models.groupData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new groupData().withName("test1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[] {new groupData().withName("test2").withHeader("header2").withFooter("footer2")});
    list.add(new Object[] {new groupData().withName("test3").withHeader("header3").withFooter("footer3")});
    return list.iterator();
  }

  @Test (dataProvider = "validGroups")
  public void testGroupCreation(groupData group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(),equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
