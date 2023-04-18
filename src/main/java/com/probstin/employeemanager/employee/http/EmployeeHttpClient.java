package com.probstin.employeemanager.employee.http;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.probstin.employeemanager.external.employee.model.ExternalEmployee;

@FeignClient(value = "employeeclient", url = "${employee.feign.client.url}")
public interface EmployeeHttpClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ssn/{ssn}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ExternalEmployee> getEmployeeBySsn(@PathVariable("ssn") String ssn);

    @RequestMapping(method = RequestMethod.GET, value = "/badge/{badge}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ExternalEmployee> getEmployeeByBadge(@PathVariable("badge") String badge);

}
