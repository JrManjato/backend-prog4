package com.example.prog4.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"employee\"")
@EqualsAndHashCode
@ToString
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    private String firstName;
    private String lastName;

    private LocalDate birthDate;

    @Lob
    private String image;
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="sex")
    private Sex sex;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @Column
    private String personalEmail;

    @Column
    private String professionalEmail;

    @Column
    private String CIN;

    @Column
    private String post;

    @Column
    private int children;

    @Column
    private LocalDate entranceDate;

    @Column
    private LocalDate departingDate;

    @Column
    private String CNAPS;

    @Column
    @Enumerated(EnumType.STRING)
    private SocioProfesionalCategory socioProfesionalCategory;

    public enum Sex {
        Male, Female
    }
    public enum SocioProfesionalCategory {
        M1, M2, OS1, OS2, OS3, OP1A, OP1B, OP2A, OP2B, OP3
    }
}