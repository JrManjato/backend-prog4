package com.example.prog4.controller.mapper;

import com.example.prog4.model.Compagny;
import com.example.prog4.model.ViewCompagny;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Component
public class CompagnyMapper {
  public Compagny toDomain(ViewCompagny compagny) {
    Compagny domainCompagny = Compagny.builder()
            .name(compagny.getName())
            .description(compagny.getDescription())
            .email(compagny.getEmail())
            .slogan(compagny.getSlogan())
            .address(compagny.getAddress())
            .phoneNumbers(compagny.getPhoneNumbers())
            .nif(compagny.getNif())
            .stat(compagny.getStat())
            .rcs(compagny.getRcs())
            .build();
    try {
      MultipartFile imageFile = compagny.getLogo();
      if (imageFile != null && !imageFile.isEmpty()) {

        byte[] imageBytes = imageFile.getBytes();


        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        domainCompagny.setLogo(base64Image);
      }
      return domainCompagny;
    } catch (Exception e) {
      throw new RuntimeException("Bad Request");
    }
  }
}
