package com.example.valueobjects.application.request;

import com.example.valueobjects.entity.customer.Customer;
import com.example.valueobjects.entity.customer.valueObject.Address;
import com.example.valueobjects.entity.customer.valueObject.FirstName;
import com.example.valueobjects.entity.customer.valueObject.LastName;
import com.example.valueobjects.entity.customer.valueObject.PhoneNumber;
import lombok.Builder;
import lombok.NonNull;

import java.util.List;
@Builder
public record CustomerRegistrationRequest(
        @NonNull
        FirstName firstName,
        @NonNull
        LastName lastName,
        @NonNull
        PhoneNumber phoneNumber,
        List<Address> address

) {
    public Customer getCustomer(){
        return Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .address(address)
                .build();
    }
}
