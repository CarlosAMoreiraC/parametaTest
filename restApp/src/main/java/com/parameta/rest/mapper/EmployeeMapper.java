package com.parameta.rest.mapper;

import com.parameta.soap.Employee;
import com.parameta.rest.dto.EmployeeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "age", source = "age")
    @Mapping(target= "vinculationTime", source="vinculationTime")
    EmployeeResponseDTO employeeToEmployeeResponseDTO(Employee employee, String age, String vinculationTime);


    @Mapping(target = "names", source = "names")
    @Mapping(target = "lastNames", source = "lastNames")
    @Mapping(target = "documentType", source = "documentType")
    @Mapping(target = "documentNumber", source = "documentNumber")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "vinculationDate", source = "vinculationDate")
    @Mapping(target = "role", source = "role")
    @Mapping(target = "salary", source = "salary")
    Employee mapToEmployee(String names, String lastNames, String documentType, String documentNumber,
                           String birthDate, String vinculationDate, String role, String salary);
}
