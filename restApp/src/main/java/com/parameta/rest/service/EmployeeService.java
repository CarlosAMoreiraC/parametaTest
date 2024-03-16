package com.parameta.rest.service;

import com.parameta.rest.dto.EmployeeResponseDTO;
import com.parameta.rest.exception.UnprocessableException;
import com.parameta.rest.facade.EmployeeFacade;
import com.parameta.rest.mapper.EmployeeMapper;
import com.parameta.soap.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeFacade employeeFacade;

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * Returns information of the employee.
     * In addition, it calculates the length of connection to the
     * company and the age of the employee.
     */

    public EmployeeResponseDTO fetchEmployee(String names, String lastNames, String documentType, String documentNumber,
                                             String birthDate, String vinculationDate, String role, String salary) {

        isValidDate(birthDate);
        isValidDate(vinculationDate);

        Employee employee = employeeMapper.mapToEmployee(names, lastNames, documentType, documentNumber, birthDate, vinculationDate, role, salary);
        Employee response = employeeFacade.save(employee);

        LocalDate vinculationTime = LocalDate.of(response.getVinculationDate().getYear(), response.getVinculationDate().getMonth(), response.getVinculationDate().getDay());
        LocalDate age = LocalDate.of( response.getBirthDate().getYear(), response.getBirthDate().getMonth(), response.getBirthDate().getDay());

        String vinculationYears = getCurrentYearsMonthAndDays(vinculationTime, "vinculation time");
        String ageInYears = getCurrentYearsMonthAndDays(age, "age");

        return employeeMapper.employeeToEmployeeResponseDTO(employee, ageInYears, vinculationYears);
    }

    /**
     * Validates if the date comes in the format YYYY-MM-DD.
     */
    private void isValidDate(String date) {
        try {
            LocalDate.parse(date);
        } catch (Exception e) {
            throw new UnprocessableException("Date: " + date + " is invalid");
        }
    }

    /**
     * Calculates the time in years, weeks and days since a date.
     */
    private String getCurrentYearsMonthAndDays(LocalDate startDate, String topic) {
        LocalDate currentDate = LocalDate.now();
        long year, week, days;

        long numberOfDays = startDate.until(currentDate, ChronoUnit.DAYS);

        year = numberOfDays / 365;
        week = (numberOfDays % 365) / 7;
        days = (numberOfDays % 365) % 7;
        return "The employee's " + topic + " is: " + year + " years with " + week + " weeks and " + days + "days";
    }
}
