package ru.stqa.pft.addressbook.generator;

import ru.stqa.pft.addressbook.models.groupData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class GroupDataGenerator {

    public static void main (String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<groupData> groups = generateGroups(count);
        save(groups, file);
    }

    private static void save(List<groupData> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (groupData group : groups) {
            writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
        }
        writer.close();
    }

    private static List<groupData> generateGroups(int count) {
        List<groupData> groups = new ArrayList<groupData>();
        for (int i = 0; i < count; i++) {
            groups.add(new groupData().withName(String.format("test %s", i))
                    .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s",i)));
        }
        return groups;
    }
}
