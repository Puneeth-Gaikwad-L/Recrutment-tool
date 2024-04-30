package com.example.recrutmenttool.models;


import com.example.recrutmenttool.Enum.DocumentStatus;
import com.example.recrutmenttool.Enum.FileType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer documentId;

    @Enumerated (value = EnumType.STRING)
    private FileType fileType;

    private Integer fileSize;

    private Date uploadDate;

    @Enumerated (value = EnumType.STRING)
    private DocumentStatus status;

    private String documentUrl;


    @ManyToOne
    @JoinColumn
    private User user;

}
