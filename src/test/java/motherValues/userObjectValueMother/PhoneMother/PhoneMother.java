package motherValues.userObjectValueMother.PhoneMother;

import com.example.valueobjects.entity.customer.valueObject.PhoneNumber;
import motherValues.MotherCreator;

public class PhoneMother {
    public static PhoneNumber randomPhoneNummer(){
        return PhoneNumber.builder().phoneNumber(MotherCreator.radom().phoneNumber().phoneNumber()).build();
    }
}
