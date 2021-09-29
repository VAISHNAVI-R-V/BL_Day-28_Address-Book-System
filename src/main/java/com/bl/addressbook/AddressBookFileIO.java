package com.bl.addressbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBookFileIO {
    /**
     * @purpose: to write the data in the file.
     *
     * @param addressBookMap
     */
    public void writeData(Map<String, AddressBook> addressBookMap) {
        //create new BufferedWriter for the output file
        File file = new File("Contacts.txt");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            //iterate map entries
            for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
                bufferedWriter.write(entry.getKey() + ":" + entry.getValue());
                bufferedWriter.newLine();
            }
            //new line
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * @param addressbookHashMap
     * @purpose: read the data.
     *
     */
    public static Map<String, String> readData(Map<String, AddressBook> addressbookHashMap) {
        Map<String, String> mapFileContents = new HashMap<>();
        BufferedReader br = null;
        try {
            //create file object
            File file = new File("Contacts.txt");

            //create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            String line = null;
            //      String line2 = "";
            //read file line by line
            while ((line = br.readLine()) != null) {

                //split the line by :
                String[] parts = line.split(":");
                //            String[] parts2 = line2.split(",");
                //  System.out.println(parts.);

                //first part is name, second is age
                String bookName = parts[0].trim();
                String fname = parts[1].trim();
//                String fName = parts[2].trim();
                //              String lName=parts2[1].trim();//parts[2].trim();
                //            String address=parts[3].trim();
                //          String city=parts[4].trim();
                //        String state=parts[5].trim();
                //      Long zip = Long.parseLong(parts[6].trim());
                //    Long phone= Long.parseLong(parts[7].trim());
                //  String email=parts[8].trim();

                mapFileContents.put(bookName, fname);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }
        return mapFileContents;
    }
}
