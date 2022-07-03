package motherValues.userObjectValueMother.name;

import com.example.valueobjects.entity.customer.valueObject.FirstName;
import motherValues.MotherCreator;

public class FirstNameMother {
    public static FirstName randomFirstName(){
        return FirstName.builder().firstName(MotherCreator.radom().name().name()).build();
    }
}
