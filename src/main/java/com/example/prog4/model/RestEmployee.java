package com.example.prog4.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class RestEmployee implements Serializable {
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private MultipartFile image;
    private String sex;
    private String phoneNumber;
    private String address;
    private String personalEmail;
    private String professionalEmail;
    private String CIN;
    private String post;
    private int children;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entranceDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departingDate;
    private String socioProfesionalCategory;
    private String CNAPS;
}
