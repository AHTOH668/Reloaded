package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.models.groupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    groupData group = new groupData().withName("test1").withFooter("test2").withHeader("test3");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(),equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
