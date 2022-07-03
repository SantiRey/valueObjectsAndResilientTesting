package com.example.valueobjects.entity.customer.valueObject;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data
public class LastName {
    String lastName;
}
