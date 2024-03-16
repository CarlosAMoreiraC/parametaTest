package com.parameta.soap.service;

import com.parameta.soap.entity.EmployeeData;
import com.parameta.soap.gen.Employee;
import com.parameta.soap.mapper.EmployeeMapper;
import com.parameta.soap.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee save(Employee employee) {
        EmployeeData employeeData = employeeMapper.employeeToEmployeeData(employee);
        employeeRepository.save(employeeData);
        return employee;
    }
}
