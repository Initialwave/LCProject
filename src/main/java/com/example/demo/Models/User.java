package com.example.demo.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import javax.persistence.Entity;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
//@Table //should this be a table or list?  How do we have several unique keys if it is in a list?
public class User extends AbstractBaseClass {
//not sure whether to use @Column(nullable-false) or @NotNull



    @NotBlank
    private String username;

//    @NotNull
//    private String pwHash;


    @Column(nullable = false, unique = true, length = 45)
    @NotBlank
    private String email;

    //@Column(nullable = false, length = 64)

     @Column(name = "first_name", nullable = false, length = 20)
    @NotBlank
    private String firstName;

//     @Column(name = "last_name", nullable = false, length = 20)
//    @NotBlank
//    private String lastName;

//     @Column(name = "phone", nullable = false, length = 10)
//    @NotBlank
//    private Integer phoneNumber;

//     @Column(name = "relationship", nullable = false )

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(){

    }

//    public User(String username, String password){};
    public User (String username, String firstName, String email) {
        super();
        this.username = username;
//        this.pwHash = encoder.encode(password);
        this.email = email;
        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;

    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

//    public boolean isMatchingPassword(String password) {
//        return encoder.matches(password, pwHash);
//    }
//    public Integer getPhoneNumber() {
//        return phoneNumber;
//    }

    public String getEmail() {
        return email;
    }

//    public String getPwHash() {
//        return pwHash;
//    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public void setPwHash(String pwHash) {
//        this.pwHash = pwHash;
//    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public void setPhoneNumber(Integer phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    public String getFirstName() {
        return firstName;
    }


//    public String getLastName() {
//        return lastName;
//    }


}
