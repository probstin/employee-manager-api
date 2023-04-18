package com.probstin.employeemanager.external.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.probstin.employeemanager.external.employee.model.ExternalEmployee;

public interface ExternalEmployeeRepository extends JpaRepository<ExternalEmployee, Long> {
    
    public Optional<ExternalEmployee>findEmployeeBySsn(String ssn);

}
