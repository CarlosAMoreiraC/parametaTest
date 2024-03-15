package com.parameta.soap.entity;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeData {

    @Id
    @Column(name="names", nullable = false)
    private String names;
    @Column(name="last_names", nullable = false)
    private String lastNames;
    @Column(name="document_type", nullable = false)
    private String documentType;
    @Column(name="document_number", nullable = false)
    private String documentNumber;
    @Column(name="birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(name="vinculation_date", nullable = false)
    private LocalDate vinculationDate;
    @Column(name="role", nullable = false)
    private String role;
    @Column(name="salary", nullable = false)
    private double salary;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getVinculationDate() {
        return vinculationDate;
    }

    public void setVinculationDate(LocalDate vinculationDate) {
        this.vinculationDate = vinculationDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
