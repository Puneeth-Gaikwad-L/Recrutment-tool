package com.example.recrutmenttool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private  String password;


    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    private ArrayList<User> userArrayList  =new ArrayList<>();

    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    private ArrayList<Client> clientArrayList = new ArrayList<Client>();






}
