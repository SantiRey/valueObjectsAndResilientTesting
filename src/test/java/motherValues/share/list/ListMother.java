package motherValues.share.list;

import java.util.List;
import java.util.function.Function;

public class ListMother<T> {
    public  List<T> listMother(T... paramiters){
        return List.of(paramiters);
    }

}
