package com.example.prog4.repository;

import com.example.prog4.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
  List<Employee> findAll(Sort sort);

  @Query(value = "SELECT * FROM employee " +
          "WHERE (LOWER(last_name) LIKE LOWER(CONCAT('%', :word, '%')) " +
          "OR LOWER(first_name) LIKE LOWER(CONCAT('%', :word, '%')) " +
          "OR sex = :word " +
          "OR LOWER(post) LIKE LOWER(CONCAT('%', :word, '%')))",
          nativeQuery = true)
  List<Employee> searchByWord(String word);

  @Query(value = "SELECT * FROM employee " +
          "WHERE entrance_date >= :startDate AND departing_date <= :endDate",
          nativeQuery = true)
  List<Employee> findAllEmployeesWithinDateRange(LocalDate startDate, LocalDate endDate);
}
