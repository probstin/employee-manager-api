package com.probstin.employeemanager.external.employee.model;

import static jakarta.persistence.GenerationType.SEQUENCE;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "external_employee_address")
public class ExternalEmployeeAddress {

    @Id
    @SequenceGenerator(name = "external_employee_address_sequence", sequenceName = "external_employee_address_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "external_employee_address_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "external_employee_id", referencedColumnName = "id")
    private ExternalEmployee externalEmployee;

    @JsonBackReference
    public ExternalEmployee getExternalEmployee() {
        return externalEmployee;
    }
}
