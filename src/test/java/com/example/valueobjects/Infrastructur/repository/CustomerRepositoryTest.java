package com.example.valueobjects.Infrastructur.repository;

import com.example.valueobjects.entity.customer.Customer;
import com.example.valueobjects.entity.customer.valueObject.PhoneNumber;
import motherValues.CustomerMother;
import motherValues.userObjectValueMother.PhoneMother.PhoneMother;
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

    @Test
    void itShouldFindPhoneNumber() {

        //Given
        Customer customerToSave = CustomerMother.getRandomUser();
        PhoneNumber phoneNumber= PhoneMother.randomPhoneNummer();
        customerToSave.setPhoneNumber(phoneNumber);
        Customer customerSaved = customerRepository.save(customerToSave);

        //When
        Optional<Customer> customerFromDb = customerRepository
                .findCustomerByPhoneNumber(phoneNumber);

        //Then
        assertThat(customerFromDb).isPresent().hasValueSatisfying(customer -> {
            assertThat(customer.getId().equals(customerSaved.getId()));
            assertThat(customer.getFirstName().equals(customerToSave.getFirstName()));
            assertThat(customer.getPhoneNumber().equals(customerToSave.getPhoneNumber()));
        });
    }
}