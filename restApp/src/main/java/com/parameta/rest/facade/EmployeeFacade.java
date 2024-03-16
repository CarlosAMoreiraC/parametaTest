package com.parameta.rest.facade;

import com.parameta.soap.Employee;
import com.parameta.soap.SaveEmployeeRequest;
import com.parameta.soap.SaveEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class EmployeeFacade {

    private static final String SOAP_WS_URL = "http://localhost:8080/ws";
    @Autowired
    Jaxb2Marshaller marshaller;

    @Autowired
    WebServiceTemplate webServiceTemplate;

    /**
     * Call the soap service responsible for saving the employee's information.
     */
    public Employee save(Employee employee) {
        SaveEmployeeRequest request = new SaveEmployeeRequest();
        request.setEmployee(employee);

        SaveEmployeeResponse response = (SaveEmployeeResponse) webServiceTemplate.marshalSendAndReceive(SOAP_WS_URL, request);

        return response.getEmployee();
    }


}
