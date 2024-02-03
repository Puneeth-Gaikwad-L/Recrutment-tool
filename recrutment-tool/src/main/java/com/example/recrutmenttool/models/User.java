package com.example.recrutmenttool.models;

import com.example.recrutmenttool.Enum.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false,unique = true)
    private String emailId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String organization;

    @Enumerated (value = EnumType.STRING)
    private AccountStatus accountStatus;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;












}
