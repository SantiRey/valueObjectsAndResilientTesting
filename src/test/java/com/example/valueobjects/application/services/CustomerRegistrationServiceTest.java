package com.example.valueobjects.application.services;

import com.example.valueobjects.Infrastructur.repository.CustomerRepository;
import com.example.valueobjects.application.request.CustomerRegistrationRequest;
import com.example.valueobjects.entity.customer.Customer;
import com.example.valueobjects.entity.customer.valueObject.PhoneNumber;
import motherValues.CustomerRegistrationRequestMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.times;
import static org.mockito.BDDMockito.verify;
import static org.mockito.Mockito.never;

class CustomerRegistrationServiceTest {
    @Captor
    ArgumentCaptor<Customer> customerArgumentCaptor;
    @Mock
    private CustomerRepository customerRepository;
    CustomerRegistrationService customerRegistrationService;
    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        customerRegistrationService = new CustomerRegistrationService(customerRepository);
    }
    @Test
    void itShouldRegisterNewUser() {

        //Given
        CustomerRegistrationRequest customerRegistrationRequest = CustomerRegistrationRequestMother
                .randomCustomerRegistrationRequest();
        given(customerRepository.findCustomerByPhoneNumber(any(PhoneNumber.class)))
                .willReturn(Optional.empty());

        //When
        customerRegistrationService.registerNewCustomer(customerRegistrationRequest);

        //Then
        verify(customerRepository).findCustomerByPhoneNumber(any(PhoneNumber.class));
        then(customerRepository).should(times(1)).save(customerArgumentCaptor.capture());
        Customer customerArgumentCaptorValue = customerArgumentCaptor.getValue();
        assertThat(customerArgumentCaptorValue.equals(customerRegistrationRequest.getCustomer()));
    }

    @Test
    void itShouldNotRegisterCustomerWhenCustomerExist() {
        //Given
        CustomerRegistrationRequest customerRegistrationRequest = CustomerRegistrationRequestMother.randomCustomerRegistrationRequest();
        given(customerRepository.findCustomerByPhoneNumber(customerRegistrationRequest.phoneNumber()))
                .willReturn(Optional.of(customerRegistrationRequest.getCustomer()));

        //When
        assertThatThrownBy(() ->
            customerRegistrationService.registerNewCustomer(customerRegistrationRequest))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Customer Alredy exist");

        //Then
        then(customerRepository)
                .should(times(1))
                .findCustomerByPhoneNumber(customerRegistrationRequest.phoneNumber());
        then(customerRepository).shouldHaveNoMoreInteractions();
    }
}