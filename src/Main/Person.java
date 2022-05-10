package Main;

//Contains all information in a Person that could be show on the AddressPanel
import java.util.Scanner;
import java.io.FileWriter;

public class Person {
    private String title, firstName, lastName,
            houseNumber, street, postCode, city, country,
            telefon, email;
    
    public Person() {
    }
    
    public void loadFromScanner(Scanner scanner) {
        setTitle(scanner.nextLine());
        setFirstName(scanner.nextLine());
        setLastName(scanner.nextLine());
        setStreet(scanner.nextLine());
        setHouseNumber(scanner.nextLine());
        setPostCode(scanner.nextLine());
        setCity(scanner.nextLine());
        setCountry(scanner.nextLine());
        setTelefon(scanner.nextLine());
        setEmail(scanner.nextLine());
    }
    
    public void writeToFile(FileWriter w) throws java.io.IOException {
        w.write(title+"\n");
        w.write(firstName+"\n");
        w.write(lastName+"\n");
        w.write(street+"\n");
        w.write(houseNumber+"\n");
        w.write(postCode+"\n");
        w.write(city+"\n");
        w.write(country+"\n");
        w.write(telefon+"\n");
        w.write(email+"\n");
    }
    
    //getters
    public String getTitle() {
        return  title;
    }
    
    public String getFirstName() {
        return  firstName;
    }
    
    public String getLastName() {
        return  lastName;
    }
    
    public String getStreet() {
        return  street;
    }
    
    public String getPostCode() {
        return  postCode;
    }
    
    public String getCity() {
        return  city;
    }
    
    public String getCountry() {
        return  country;
    }
    
    public String getTelefon() {
        return  telefon;
    }
    
    public String getEmail() {
        return  email;
    }
    
    public String getHouseNumber() {
        return  houseNumber;
    }
    
    //setters
    public void setTitle(String newData) {
        this.title = newData;
    }
    
    public void setFirstName(String newData) {
        this.firstName = newData;
    }
    
    public void setLastName(String newData) {
        this.lastName = newData;
    }
    
    public void setStreet(String newData) {
        this.street = newData;
    }
    
    public void setPostCode(String newData) {
        this.postCode = newData;
    }
    
    public void setCity(String newData) {
        this.city = newData;
    }
    
    public void setCountry(String newData) {
        this.country = newData;
    }
    
    public void setTelefon(String newData) {
        this.telefon = newData;
    }
    
    public void setEmail(String newData) {
        this.email = newData;
    }
    
    public void setHouseNumber(String newNumber) {
        this.houseNumber = newNumber;
    }
}
