package com.example.prog4.controller.mapper;

import com.example.prog4.model.Company;
import com.example.prog4.model.ViewCompany;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Component
public class CompanyMapper {
  public Company toDomain(ViewCompany company) {
    Company domainCompany = Company.builder()
            .name(company.getName())
            .description(company.getDescription())
            .email(company.getEmail())
            .slogan(company.getSlogan())
            .address(company.getAddress())
            .phoneNumbers(company.getPhoneNumbers())
            .nif(company.getNif())
            .stat(company.getStat())
            .rcs(company.getRcs())
            .build();
    try {
      MultipartFile imageFile = company.getLogo();
      if (imageFile != null && !imageFile.isEmpty()) {

        byte[] imageBytes = imageFile.getBytes();


        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        domainCompany.setLogo(base64Image);
      }
      return domainCompany;
    } catch (Exception e) {
      throw new RuntimeException("Bad Request");
    }
  }
}
