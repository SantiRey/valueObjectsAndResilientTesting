package com.example.valueobjects.Infrastructur.controller;

import com.example.valueobjects.application.request.CustomerRegistrationRequest;
import com.example.valueobjects.application.services.CustomerRegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customer-resgistration")
@AllArgsConstructor
public class CustomerController {
    CustomerRegistrationService customerRegistrationService;
    @PostMapping
    public void registerCustomer(
            @RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("Resquest summited" + customerRegistrationRequest);
        customerRegistrationService.registerNewCustomer(customerRegistrationRequest);
    }
}
