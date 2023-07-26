package com.example.prog4.service;

import com.example.prog4.model.Company;
import com.example.prog4.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {
  private CompanyRepository repository;

  public List<Company> getCompanies(){
    return repository.findAll();
  }

  public void saveOne(Company company) {
    repository.save(company);
  }
}
