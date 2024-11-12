package hutnyk.tpo_02;

import java.util.Collection;
import java.util.List;

public interface IReadService {

    Collection<Enn > read();
    void write(Collection<Object> list);

}
