package com.example.prog4.service;

import com.example.prog4.model.Employee;
import com.example.prog4.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository repository;


    public Employee getOne(String id){
        Optional<Employee> employee = repository.findById(id);
        if(employee.isPresent()){
            return  employee.get();
        }
        throw new RuntimeException("Not found id="+id);
    }

    public List<Employee> getAll(){
        return repository.findAll();
    }

    public void saveAll(List<Employee> employees){
        repository.saveAll(employees);
    }
    public void saveOne(Employee employee){
        repository.save(employee);
    }

    public List<Employee> sort(String sortOrder, String atr) {
        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(atr).ascending() :
                Sort.by(atr).descending();

        return repository.findAll(sort);
    }

    @Transactional

    public List<Employee> searchByWord(String word) {
        return repository.searchByWord(word);
    }

    @Transactional
    public List<Employee> findEmployeesWithinDateRange(LocalDate entranceDate, LocalDate departingDate) {
        return repository.findAllEmployeesWithinDateRange(entranceDate, departingDate);
    }
}
