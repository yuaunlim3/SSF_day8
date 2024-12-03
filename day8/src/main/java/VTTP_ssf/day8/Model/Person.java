package VTTP_ssf.day8.Model;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Person {

    //required size between 5 to 150 characters
    @NotEmpty(message = "Name cannot be empty")
    private String fullName;

    //required
    private Integer id;
    
    //required and email format
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Must be valid email")
    private String email;


    //between 111111 to 888888
    @Min(value = 111111, message="Postcode out of range")
    @Max(value = 888888, message="Postcode out of range")
    private String postalCode;


    // 7 digits number only use regular expression
    @Min(value = 1000000, message="Phone number is invalid")
    @Max(value = 9999999, message="Phone number is invalid")
    private String phoneNumber;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return fullName + "," + id + "," + email + "," + postalCode
                + "," + phoneNumber;
    }


    public static Person fromString(String infos){
        String[] personInfo = infos.split(",");
        Person person = new Person();

        person.setFullName(personInfo[0]);
        person.setId(Integer.parseInt(personInfo[1]));
        person.setEmail(personInfo[2]);
        person.setPostalCode(personInfo[3]);
        person.setPhoneNumber(personInfo[4]);
        System.out.printf(">>>>>>>>>>>>Person created: %s\n",person.toString());
        return person;
    }
    

    

}
