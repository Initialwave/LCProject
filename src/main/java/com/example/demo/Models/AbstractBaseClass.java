package com.example.demo.Models;


//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@MappedSuperclass
public abstract class AbstractBaseClass {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    @NotBlank(message="please provide a name.")
    @Size(min = 3, max = 100, message = "name must contain between 3 and 100 characters")
    private String name;

    public int getId() { return id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBaseClass that = (AbstractBaseClass) o;
        return id == that.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

}
