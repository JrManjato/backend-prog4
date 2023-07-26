package com.example.prog4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"company\"")
@EqualsAndHashCode
@ToString
public class Company implements Serializable {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String id;

  private String name;
  private String description;
  private String email;
  private String slogan;
  private String address;
  private String phoneNumbers;
  private String nif;
  private String stat;
  private String rcs;

  @Lob
  private String logo;
}