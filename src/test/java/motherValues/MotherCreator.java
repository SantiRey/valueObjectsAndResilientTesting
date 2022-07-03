package motherValues;

import com.github.javafaker.Faker;

public class MotherCreator {
    private static final Faker faker = new Faker();

    public static Faker radom(){
        return faker;
    }
}
