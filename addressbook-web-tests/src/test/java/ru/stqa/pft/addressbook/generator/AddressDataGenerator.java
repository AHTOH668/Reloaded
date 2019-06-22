package ru.stqa.pft.addressbook.generator;

import ru.stqa.pft.addressbook.models.addressData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class AddressDataGenerator {

    public static void main (String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<addressData> contacts = generateContacts(count);
        save(contacts, file);
    }

    private static void save(List<addressData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (addressData contact : contacts) {
            writer.write(String.format("%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getEmail()));
        }
        writer.close();
    }

    private static List<addressData> generateContacts(int count) {
        List<addressData> contacts = new ArrayList<addressData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new addressData().withFirstName(String.format("Антон %s", i))
                    .withLastName(String.format("Подд %s", i)).withEmail(String.format("123@email.ru %s",i)));
        }
        return contacts;
    }
}
