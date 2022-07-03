package com.example.valueobjects.entity.customer;

import com.example.valueobjects.entity.customer.valueObject.Address;
import com.example.valueobjects.entity.customer.valueObject.FirstName;
import com.example.valueobjects.entity.customer.valueObject.LastName;
import com.example.valueobjects.entity.customer.valueObject.PhoneNummer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Embedded
    FirstName firstName;

    @Embedded
    LastName lastName;

    @Embedded
    PhoneNummer phoneNummer;

    @ElementCollection(targetClass = Address.class, fetch = FetchType.EAGER)
    List<Address> address = new ArrayList<>();

}
