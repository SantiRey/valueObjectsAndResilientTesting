package motherValues;

import com.example.valueobjects.entity.customer.Customer;
import motherValues.userObjectValueMother.address.AddressMother;
import motherValues.userObjectValueMother.name.FirstNameMother;
import motherValues.userObjectValueMother.name.LastNameMother;

import java.util.Arrays;

public class CustomerMother {
    public static Customer getRandomUser(){
        return Customer.builder()
                .firstName(FirstNameMother.randomFirstName())
                .lastName(LastNameMother.LastNameMother())
                .address(
                        Arrays.asList(
                                AddressMother.randomAddress(),
                                AddressMother.randomAddress()
                        )
                ).build();
    }
}
