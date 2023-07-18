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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Lob
    private String image;
    private String registrationNumber;
}