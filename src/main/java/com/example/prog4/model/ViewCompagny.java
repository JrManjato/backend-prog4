package com.example.prog4.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@Builder
public class ViewCompagny implements Serializable {
  private String name;
  private String description;
  private String email;
  private String slogan;
  private String address;
  private String phoneNumbers;
  private String nif;
  private String stat;
  private String rcs;
  private MultipartFile logo;
}
