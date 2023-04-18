package com.probstin.employeemanager.config;

import com.probstin.employeemanager.exception.BadRequestException;
import com.probstin.employeemanager.exception.NotFoundException;
import com.probstin.employeemanager.exception.ServiceNotAvailableException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignClientDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException();
            case 404:
                return new NotFoundException("Employee not found");
            case 503:
                return new ServiceNotAvailableException("Employee Api is unavailable");
            default:
                return new Exception("Exception while fetching employee details");
        }
    }

}
