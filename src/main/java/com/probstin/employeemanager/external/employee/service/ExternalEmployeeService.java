package com.probstin.employeemanager.external.employee.service;

import org.springframework.stereotype.Service;

import com.probstin.employeemanager.external.employee.model.ExternalEmployee;
import com.probstin.employeemanager.external.employee.repository.ExternalEmployeeRepository;

@Service
public class ExternalEmployeeService {

    private final ExternalEmployeeRepository externalEmployeeRepository;

    public ExternalEmployeeService(ExternalEmployeeRepository externalEmployeeRepository) {
        this.externalEmployeeRepository = externalEmployeeRepository;
    }

    public ExternalEmployee getEmployeeBySsn(String ssn) {
        return externalEmployeeRepository
                .findEmployeeBySsn(ssn)
                .orElseThrow(() -> new RuntimeException("Employee with SSN: " + ssn + " not found."));
    }

}
