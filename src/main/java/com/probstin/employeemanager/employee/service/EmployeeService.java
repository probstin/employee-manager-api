package com.probstin.employeemanager.employee.service;

import org.springframework.stereotype.Service;

import com.probstin.employeemanager.employee.http.EmployeeHttpClient;
import com.probstin.employeemanager.employee.model.EmployeeDTO;
import com.probstin.employeemanager.employee.model.EmployeeDTOMapper;
import com.probstin.employeemanager.employee.model.EmployeeIdentifier;
import com.probstin.employeemanager.external.employee.model.ExternalEmployee;

@Service
public class EmployeeService {

    private final EmployeeHttpClient employeeClient;
    private final EmployeeDTOMapper employeeDTOMapper;

    public EmployeeService(EmployeeHttpClient employeeClient, EmployeeDTOMapper employeeDTOMapper) {
        this.employeeClient = employeeClient;
        this.employeeDTOMapper = employeeDTOMapper;
    }

    public EmployeeDTO findEmployeeByIdAndIdentifier(String id, EmployeeIdentifier employeeIdentifierType) {
        switch (employeeIdentifierType) {
            case SSN:
                System.out.println("SSN");
                return getEmployeeBySsn(id);
            default:
                return null;
        }
    }

    public EmployeeDTO getEmployeeBySsn(String ssn) {
        ExternalEmployee externalEmployee = employeeClient
                .getEmployeeBySsn(ssn)
                .getBody();

        if (externalEmployee == null) {
            throw new RuntimeException("Could not find employee with SSN: " + ssn);
        }

        return employeeDTOMapper.apply(externalEmployee);
    }

}
