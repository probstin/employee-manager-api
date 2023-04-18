package com.probstin.employeemanager.employee.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.probstin.employeemanager.employee.model.EmployeeDTO;
import com.probstin.employeemanager.employee.model.EmployeeIdentifier;
import com.probstin.employeemanager.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("{id}")
    @ResponseStatus(OK)
    public EmployeeDTO getEmployeeById(
            @PathVariable String id,
            @RequestParam(name = "type", defaultValue = "ssn") EmployeeIdentifier employeeIdentifierType) {
        return employeeService.findEmployeeByIdAndIdentifier(id, employeeIdentifierType);
    }

}
