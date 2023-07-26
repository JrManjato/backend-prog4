package com.example.prog4.controller.mapper;

import com.example.prog4.model.EditEmployee;
import com.example.prog4.model.Employee;
import com.example.prog4.model.ViewEmployee;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Component
public class EmployeeMapper {
    public Employee toDomain(ViewEmployee employee){
        Employee domainEmployee = Employee.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .birthDate(employee.getBirthDate())
                .sex(Employee.Sex.valueOf(employee.getSex()))
                .professionalEmail(employee.getProfessionalEmail())
                .personalEmail(employee.getPersonalEmail())
                .phoneNumber(employee.getPhoneNumber())
                .CIN(employee.getCIN())
                .post(employee.getPost())
                .children(employee.getChildren())
                .departingDate(employee.getDepartingDate())
                .entranceDate(employee.getEntranceDate())
                .address(employee.getAddress())
                .CNAPS(employee.getCNAPS())
                .socioProfesionalCategory(Employee.SocioProfesionalCategory.valueOf(employee.getSocioProfesionalCategory()))
                .build();
        try {
            MultipartFile imageFile = employee.getImage();
            if (imageFile != null && !imageFile.isEmpty()) {

                byte[] imageBytes = imageFile.getBytes();


                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                domainEmployee.setImage(base64Image);
            }
            return domainEmployee;
        }
        catch (Exception e){
            throw new RuntimeException("Bad Request");
        }
    }
    public Employee toDomain(EditEmployee editEmployee){
        Employee domainEmployee = Employee.builder()
                .id(editEmployee.getId())
                .registrationNumber(editEmployee.getRegistrationNumber())
                .firstName(editEmployee.getFirstName())
                .lastName(editEmployee.getLastName())
                .birthDate(editEmployee.getBirthDate())
                .sex(Employee.Sex.valueOf(editEmployee.getSex()))
                .professionalEmail(editEmployee.getProfessionalEmail())
                .personalEmail(editEmployee.getPersonalEmail())
                .phoneNumber(editEmployee.getPhoneNumber())
                .CIN(editEmployee.getCIN())
                .post(editEmployee.getPost())
                .children(editEmployee.getChildren())
                .departingDate(editEmployee.getDepartingDate())
                .entranceDate(editEmployee.getEntranceDate())
                .address(editEmployee.getAddress())
                .CNAPS(editEmployee.getCNAPS())
                .socioProfesionalCategory(Employee.SocioProfesionalCategory.valueOf(editEmployee.getSocioProfesionalCategory()))
                .build();
        try {
            MultipartFile imageFile = editEmployee.getImage();
            if (imageFile != null && !imageFile.isEmpty()) {

                byte[] imageBytes = imageFile.getBytes();


                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                domainEmployee.setImage(base64Image);
            }
            return domainEmployee;
        }
        catch (Exception e){
            throw new RuntimeException("Bad Request");
        }

    }
}
