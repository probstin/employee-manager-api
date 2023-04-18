package com.probstin.employeemanager.employee.model;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.probstin.employeemanager.external.employee.model.ExternalEmployee;

@Service
public class EmployeeDTOMapper implements Function<ExternalEmployee, EmployeeDTO> {

        @Override
        public EmployeeDTO apply(ExternalEmployee employee) {
                return new EmployeeDTO(
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getGender(),
                                employee.getEmail(),
                                employee.getDepartment(),
                                employee.getExternalEmployeeAddresses()
                                                .stream()
                                                .map(address -> new AddressDTO(
                                                                address.getStreet(),
                                                                address.getCity(),
                                                                address.getState(),
                                                                address.getZipCode()))
                                                .collect(Collectors.toList()));
        }

}
