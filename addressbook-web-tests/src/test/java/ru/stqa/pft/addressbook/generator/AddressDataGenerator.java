package ru.stqa.pft.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
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
        save(contacts, new File(file));
    }

    private void save(List<addressData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (addressData contact : contacts) {
            writer.write(String.format("%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getEmail()));
        }
        writer.close();
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
