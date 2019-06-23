package ru.stqa.pft.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.models.addressData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class AddressDataGenerator {

    @Parameter(names =  "-c", description = "Group count")
    public int count;

    @Parameter (names = "-f", description = "Target file")
    public String file;

    @Parameter (names = "-d", description = "Data format")
    public String format;

    public static void main (String[] args) throws IOException {
        AddressDataGenerator generator = new AddressDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
        }
        generator.run();
    }

    private void run() throws IOException {
        List<addressData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private void saveAsJson(List<addressData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private void saveAsCsv(List<addressData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        try (Writer writer = new FileWriter(file)) {
            for (addressData contact : contacts) {
                writer.write(String.format("%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getEmail()));
            }
        }
    }

    private void save(List<addressData> contacts, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (addressData contact : contacts) {
                writer.write(String.format("%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getEmail()));
            }
        }
    }

    private List<addressData> generateContacts(int count) {
        List<addressData> contacts = new ArrayList<addressData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new addressData().withFirstName(String.format("Антон %s", i))
                    .withLastName(String.format("Подд %s", i)).withEmail(String.format("123@email.ru %s",i)));
        }
        return contacts;
    }
}
