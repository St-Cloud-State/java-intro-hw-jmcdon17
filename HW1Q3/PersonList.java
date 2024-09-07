package HW1Q3;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
    LinkedList<Person> linkList;
    // Constructor
    public PersonList() {
        linkList = new LinkedList<Person>();    //Java linked list class
    }

    public void store(InputStream inStream) {
        String firstName, lastName, id;
        Scanner inputScanner = new Scanner(inStream);
        while (inputScanner.hasNext()) {
            firstName = inputScanner.nextLine(); // get first name from user
            lastName = inputScanner.nextLine(); // get last name from user
            id = inputScanner.nextLine(); // get id from user
            Person person = new Person(firstName, lastName, id);
            linkList.add(person); // add person to linked list
        }
        //inputScanner.close();
    }

    public void display(OutputStream oStream) {
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

    public int find(String sid) {
        for (int i = 0; i < linkList.size(); i++) {
            Person person = linkList.get(i); // gets the next person in the linked list
            String id = person.getid();
            if (id == sid) {
                return i;
            }
        }
        return -1;  //returns -1 if it can't find them
    }

}
