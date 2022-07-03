package com.example.valueobjects.application.services;

import com.example.valueobjects.Infrastructur.repository.CustomerRepository;
import com.example.valueobjects.application.request.CustomerRegistrationRequest;
import com.example.valueobjects.entity.customer.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerRegistrationService {

    CustomerRepository customerRepository;

    public void registerNewCustomer(CustomerRegistrationRequest customerRegistrationRequest){

        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .phoneNumber(customerRegistrationRequest.phoneNumber())
                .address(customerRegistrationRequest.address())
                .build();

        customerRepository.save(customer);

    }

}
