package com.probstin.employeemanager.employee.model;

import java.util.List;

import com.probstin.employeemanager.external.employee.model.ExternalEmployeeGender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private ExternalEmployeeGender gender;
    private String email;
    private String department;
    private List<AddressDTO> addresses;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
