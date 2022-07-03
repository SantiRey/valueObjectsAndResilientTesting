package com.example.valueobjects.Infrastructur.repository;

import com.example.valueobjects.entity.customer.Customer;
import motherValues.CustomerMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    void itShouldSaveUser() {

        Customer customerToSave = CustomerMother.getRandomUser();

        customerRepository.save(customerToSave);
    }

    @Test
    void itShouldContainsCustomer() {

        Customer customerToSave = CustomerMother.getRandomUser();

        Customer customedSaved = customerRepository.save(customerToSave);
        Optional<Customer> customergotFromDb = customerRepository.findById(customedSaved.getId());

        assertThat(customergotFromDb).isPresent().hasValueSatisfying(customer -> {
            assertThat(customer.getId().equals(customedSaved.getId()));
            assertThat(customer.getFirstName().equals(customerToSave.getFirstName()));
        });
    }
}