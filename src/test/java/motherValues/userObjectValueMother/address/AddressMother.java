package motherValues.userObjectValueMother.address;

import com.example.valueobjects.entity.customer.valueObject.Address;
import motherValues.MotherCreator;

public class AddressMother {
    public static Address randomAddress(){
        return Address.builder()
                .addressNummer(MotherCreator.radom().address().streetAddressNumber())
                .street(MotherCreator.radom().address().streetAddress()).build();

    }
}
