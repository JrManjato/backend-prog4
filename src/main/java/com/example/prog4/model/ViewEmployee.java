package com.example.prog4.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class ViewEmployee implements Serializable {
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private MultipartFile image;
    private String sex;
    private String phoneNumber;
    private String address;
    private String personalEmail;
    private String professionalEmail;
    private String CIN;
    private String post;
    private int children;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate entranceDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate departingDate;
    private String socioProfesionalCategory;
    private String CNAPS;
}
