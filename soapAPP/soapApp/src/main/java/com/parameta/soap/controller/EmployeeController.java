package com.parameta.soap.controller;

import com.parameta.soap.gen.SaveEmployeeRequest;
import com.parameta.soap.gen.SaveEmployeeResponse;
import com.parameta.soap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeController {

    private static final String NAMESPACE_URI = "http://www.parameta.com/soap/gen";

    @Autowired
    private EmployeeService employeeService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SaveEmployeeRequest")
    @ResponsePayload
    public SaveEmployeeResponse saveEmployee(@RequestPayload SaveEmployeeRequest request) {
        SaveEmployeeResponse response = new SaveEmployeeResponse();
        response.setEmployee(employeeService.save(request.getEmployee()));
        return response;
    }
}
