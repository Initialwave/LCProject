package com.example.demo.Models;


import jakarta.persistence.Entity;
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

    @NotNull
    private String pwHash;


    //@Column(nullable = false, unique = true, length = 45)
    @NotBlank
    private String email;

    //@Column(nullable = false, length = 64)

    // @Column(name = "first_name", nullable = false, length = 20)
    @NotBlank
    private String firstName;

    // @Column(name = "last_name", nullable = false, length = 20)
    @NotBlank
    private String lastName;

    // @Column(name = "phone", nullable = false, length = 10)
    @NotBlank
    private Integer phoneNumber;

    // @Column(name = "relationship", nullable = false, )

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //public User() {    }

    //public User(String username, String password){};
    public User (String username, String firstName, String lastName, Integer phoneNumber, String email, String password) {
        super();
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

    }

    public User() {

    }

   public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }



    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


}
