package com.example.prog4.service;

import com.example.prog4.model.Compagny;
import com.example.prog4.model.Employee;
import com.example.prog4.repository.CompagnyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CompagnyService {
  private CompagnyRepository repository;


  public Compagny getOne(String id) {
    Optional<Compagny> compagny = repository.findById(id);
    if (compagny.isPresent()) {
      return compagny.get();
    }
    throw new RuntimeException("Not found id=" + id);
  }

  public void saveOne(Compagny compagny) {
    repository.save(compagny);
  }
}
