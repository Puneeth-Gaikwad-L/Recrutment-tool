package com.example.recrutmenttool.models;

import com.example.recrutmenttool.Enum.accountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String organization;

    @Enumerated (value = EnumType.STRING)
    private accountStatus accountStatus;



    @JoinColumn
    @ManyToOne
    private Admin admin;









}
