package com.bl.addressbook;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

import static com.bl.addressbook.AddressBook.contactList;

public class AddressBookJSON {
    /**
     * @purose: to Write in JSON file.
     *
     * @param: writeDataToJSon
     * @throws IOException
     */
    public static void writeDataToJSon() throws IOException {
        {
            Path filePath = Paths.get("Contacts.json");
            Gson gson = new Gson();
            String json = gson.toJson(contactList);
            FileWriter writer = new FileWriter(String.valueOf(filePath));
            writer.write(json);
            writer.close();
        }
    }

    /**
     * @purose: to Read in JSON file.
     *
     * @param: writeDataToJSon
     * @throws IOException
     */
    public static void readDataFromJson() throws IOException {
        ArrayList<Contacts> contactList = null;
        Path filePath = Paths.get("Contacts.json");
        try (Reader reader = Files.newBufferedReader(filePath);) {
            Gson gson = new Gson();
            contactList = new ArrayList<Contacts>(Arrays.asList(gson.fromJson(reader, Contacts[].class)));
            for (Contacts contact : contactList) {
                System.out.println("Firstname : " + contact.getFirstName());
                System.out.println("Lastname : " + contact.getLastName());
                System.out.println("City : " + contact.getCity());
                System.out.println("State : " + contact.getState());
                System.out.println("Zip Code : " + contact.getPin());
                System.out.println("Phone number : " + contact.getMobileNo());
                System.out.println("Email : " + contact.getEmail());
            }
        }
    }
}


