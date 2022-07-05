package com.example.valueobjects.application.services;

import com.example.valueobjects.Infrastructur.repository.CustomerRepository;
import com.example.valueobjects.application.request.CustomerRegistrationRequest;
import com.example.valueobjects.entity.customer.Customer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRegistrationService {

    CustomerRepository customerRepository;

    public void registerNewCustomer(CustomerRegistrationRequest customerRegistrationRequest){

        log.info("Valitation in progress for new customer");
        Optional<Customer> customerDB = customerRepository
                .findCustomerByPhoneNumber(customerRegistrationRequest.phoneNumber());

        if(customerDB.isPresent()){
            throw new IllegalStateException("Customer Alredy exist");
        }

        customerRepository.save(customerRegistrationRequest.getCustomer());
    }

}
