package com.example.crud.mongodb.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Document(collection = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Indexed(unique = true)

    private String firstName;
    private String lastName;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String emailId;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }

    public Employee(String firstName, String lastName, String emailId){
        this.firstName=firstName;
        this.lastName=lastName;
        this.emailId=emailId;
    }
}
