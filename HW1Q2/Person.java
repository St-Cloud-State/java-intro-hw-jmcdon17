package HW1Q2;

public class Person {
    private String firstName;
    private String lastName;
    private String id;
    public String getfirstName() {
        return firstName;
    }
    public String getlastName() {
        return lastName;
    }
    public String getid() {
        return id;
    }
    public void setfirstName(String fName) {
        firstName = fName;
    }
    public void setlastName(String lName) {
        lastName = lName;
    }
    public void setid(String iD) {
        id = iD;
    }
    //constructor
    public Person(String fiName, String laName, String ID) {
        firstName = fiName;
        lastName = laName;
        id = ID;
    }
    public String toString() {
        return (firstName + '\n' + lastName + '\n' + id + '\n');
    }
}
