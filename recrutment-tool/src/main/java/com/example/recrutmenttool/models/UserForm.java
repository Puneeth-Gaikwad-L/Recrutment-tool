package com.example.recrutmenttool.models;

import jakarta.persistence.Access;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserForm {


    @GeneratedValue
    @Id
    int id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    String phone;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String mobile;

    @Column(nullable = false)
    int experienceInYears;

    @Column(nullable = false)
    String relevantExperience;

    @Column(nullable = false)
    String highestQualificationHeld;

    @Column(nullable = false)
    String skillSet;

    @Column(nullable = false)
    String currentJobTitle;

    @Column(nullable = false)
    String currentWorkLocation;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    String zipCode;

    @Column(nullable = false)
    MultipartFile resumeUpload;
}
