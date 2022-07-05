package motherValues;

import com.example.valueobjects.application.request.CustomerRegistrationRequest;
import motherValues.userObjectValueMother.PhoneMother.PhoneMother;
import motherValues.userObjectValueMother.address.AddressMother;
import motherValues.userObjectValueMother.name.FirstNameMother;
import motherValues.userObjectValueMother.name.LastNameMother;

import java.util.List;

public class CustomerRegistrationRequestMother {
    public static CustomerRegistrationRequest randomCustomerRegistrationRequest(){
        return CustomerRegistrationRequest.builder()
                .firstName(FirstNameMother.randomFirstName())
                .lastName(LastNameMother.LastNameMother())
                .address(List.of(AddressMother.randomAddress()))
                .phoneNumber(PhoneMother.randomPhoneNummer())
                .build();
    }
}
