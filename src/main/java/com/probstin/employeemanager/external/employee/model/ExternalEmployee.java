package com.probstin.employeemanager.external.employee.model;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "external_employee", uniqueConstraints = {
        @UniqueConstraint(name = "external_employee_email_unique", columnNames = "email")
})
public class ExternalEmployee {

    @Id
    @SequenceGenerator(name = "external_employee_sequence", sequenceName = "external_employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "external_employee_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private ExternalEmployeeGender gender;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "department")
    private String department;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private String salary;

    @Column(name = "ssn", nullable = false)
    private String ssn;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "externalEmployee", fetch = FetchType.LAZY)
    private List<ExternalEmployeeAddress> externalEmployeeAddresses;

    @JsonManagedReference
    public List<ExternalEmployeeAddress> getExternalEmployeeAddresses() {
        return externalEmployeeAddresses;
    }

}
