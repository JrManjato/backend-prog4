package com.example.prog4.repository;

import com.example.prog4.model.Compagny;
import com.example.prog4.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompagnyRepository extends JpaRepository<Compagny, String> {
}
