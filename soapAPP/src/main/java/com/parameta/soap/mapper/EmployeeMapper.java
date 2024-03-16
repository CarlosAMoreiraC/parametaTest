package com.parameta.soap.mapper;

import com.parameta.soap.entity.EmployeeData;
import com.parameta.soap.gen.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeData employeeToEmployeeData(Employee employee);
}
