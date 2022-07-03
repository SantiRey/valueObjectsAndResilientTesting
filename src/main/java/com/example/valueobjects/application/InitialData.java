package com.example.valueobjects.application;

import com.example.valueobjects.Infrastructur.repository.CustomerRepository;
import com.example.valueobjects.entity.customer.Customer;
import com.example.valueobjects.entity.customer.valueObject.Address;
import com.example.valueobjects.entity.customer.valueObject.FirstName;
import com.example.valueobjects.entity.customer.valueObject.LastName;
import com.example.valueobjects.entity.customer.valueObject.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@AllArgsConstructor
public class InitialData implements ApplicationListener<ApplicationReadyEvent> {
    CustomerRepository customerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info(":::::::Seeding Data:::::");
        customerRepository.save(
                Customer.builder()
                        .firstName(FirstName.builder().firstName("Kevin").build())
                        .lastName(LastName.builder().lastName("Rey").build())
                        .phoneNumber(PhoneNumber.builder().phoneNumber("300-458-2303").build())
                        .address(
                                Arrays.asList(Address.builder().addressNummer("2").street("false").build(),
                                    Address.builder().addressNummer("4").street("false").build())
                        )
                        .build());
    }
}
