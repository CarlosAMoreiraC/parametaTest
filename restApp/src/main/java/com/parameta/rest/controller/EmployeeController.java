package com.parameta.rest.controller;

import com.parameta.rest.dto.EmployeeResponseDTO;
import com.parameta.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     *  Returns information of the employee
     */
    @GetMapping
    public ResponseEntity<EmployeeResponseDTO> fetchEmployee(@RequestParam(name="names") String names, @RequestParam(name="lastNames") String lastNames,
                                                             @RequestParam(name="documentType") String documentType, @RequestParam(name="documentNumber") String documentNumber,
                                                             @RequestParam(name="birthDate") String birthDate, @RequestParam(name="vinculationDate") String vinculationDate,
                                                             @RequestParam(name="role") String role, @RequestParam(name="salary") String salary) {
        return ResponseEntity.ok().body(employeeService.fetchEmployee(names, lastNames, documentType, documentNumber, birthDate, vinculationDate,
                role, salary));
    }
}
