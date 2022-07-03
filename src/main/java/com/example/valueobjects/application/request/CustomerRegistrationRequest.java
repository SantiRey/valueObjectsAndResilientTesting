package com.example.valueobjects.application.request;

import com.example.valueobjects.entity.customer.valueObject.Address;
import com.example.valueobjects.entity.customer.valueObject.FirstName;
import com.example.valueobjects.entity.customer.valueObject.LastName;
import com.example.valueobjects.entity.customer.valueObject.PhoneNumber;

import java.util.List;

public record CustomerRegistrationRequest(
        FirstName firstName,
        LastName lastName,
        PhoneNumber phoneNumber,
        List<Address> address

) {
}
