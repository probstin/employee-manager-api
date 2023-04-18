package com.probstin.employeemanager.employee.model;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class EmployeeIdentifierConverter implements Converter<String, EmployeeIdentifier> {

    @Override
    public EmployeeIdentifier convert(String value) {
        return EmployeeIdentifier.valueOf(value.toUpperCase());
    }

}