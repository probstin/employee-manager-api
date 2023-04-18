package com.probstin.employeemanager.external.employee.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.probstin.employeemanager.external.employee.model.ExternalEmployee;
import com.probstin.employeemanager.external.employee.service.ExternalEmployeeService;

@RestController
@RequestMapping("/api/v1/external/employees")
public class ExternalEmployeeController {

    private final ExternalEmployeeService externalEmployeeService;

    public ExternalEmployeeController(ExternalEmployeeService externalEmployeeService) {
        this.externalEmployeeService = externalEmployeeService;
    }

    @GetMapping("/ssn/{ssn}")
    @ResponseStatus(OK)
    public ExternalEmployee getEmployeeBySsn(@PathVariable("ssn") String ssn) {
        return externalEmployeeService.getEmployeeBySsn(ssn);
    }

}
