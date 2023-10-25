package com.example.crud.mongodb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "student")
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Transient
    public static final String SEQUENCE_NAME = "student_sequence";

    @Id
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Indexed(unique = true)
    private String name;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String emailId;

    public Student(String name, String emailId){
        this.name=name;
        this.emailId=emailId;
    }
}
