package motherValues.userObjectValueMother.name;

import com.example.valueobjects.entity.customer.valueObject.LastName;
import motherValues.MotherCreator;

public class LastNameMother {
    public static LastName LastNameMother(){
        return LastName.builder().lastName(MotherCreator.radom().name().lastName()).build();
    }
}
