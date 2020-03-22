package daoApi;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();
    void add(T t);
}
