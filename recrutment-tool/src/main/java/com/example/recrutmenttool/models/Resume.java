package com.example.recrutmenttool.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Resume")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Resume {

    @Id
    @GeneratedValue
    int id;

    String name;

    String email;

    String KeyWords;

}
