package HW1Q2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {
    // methods
    // store(<input stream>, <linked list>) that reads the data for several persons
    // from the input stream and stores the data in the linked list.
    public static void store(InputStream inStream, LinkedList<Person> linkList) {
        String firstName, lastName, id;
        Scanner inputScanner = new Scanner(inStream);
        while (inputScanner.hasNext()) {
            firstName = inputScanner.nextLine(); // get first name from user
            lastName = inputScanner.nextLine(); // get last name from user
            id = inputScanner.nextLine(); // get id from user
            Person person = new Person(firstName, lastName, id);
            linkList.add(person); // add person to linked list
        }
    }

    public static void display(OutputStream oStream, LinkedList<Person> linkList) {
        for (int i = 0; i < linkList.size(); i++) {
            Person person = linkList.get(i); // gets the next person in the linked list
            String person1 = person.toString(); // turns the person into a string
            try {
                // Converts the string into bytes
                byte[] dataBytes = person1.getBytes();

                // Writes data to the output stream
                oStream.write(dataBytes);
            }

            catch (Exception e) {
                e.getStackTrace();
            }
        }
        /*
         * alternate method of for loop
         * for (Person person : linkList) {
         * println(person);
         * }
         */
    }

    public static int find(String sid, LinkedList<Person> linkList) {
        for (int i = 0; i < linkList.size(); i++) {
            Person person = linkList.get(i); // gets the next person in the linked list
            String id = person.getid();
            if (id == sid) {
                return i;   //returns person associated with the id
            }
        }
        return -1;  //returns -1 if it can't find them
    }

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<Person> linkList1 = new LinkedList<Person>();    // Java LinkedList class
        File file = new File("file.txt");
        InputStream iStream = new FileInputStream(file);

        //Question 2 method:
        store(iStream, linkList1);
        display(System.out, linkList1); // System.out is the output stream
        store(iStream, linkList1);
        display(System.out, linkList1);
        store(iStream, linkList1);
        display(System.out, linkList1);

        /*
        //Question 3 method:
        PersonList personList = new PersonList();
        personList.store(iStream);
        personList.display(System.out);
        personList.store(iStream);
        personList.display(System.out);
        personList.store(iStream);
        personList.display(System.out);
        
        try {
            iStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
         */
        
    }
}
