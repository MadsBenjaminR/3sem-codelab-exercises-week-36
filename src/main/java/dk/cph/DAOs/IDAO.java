package dk.cph.DAOs;

import java.util.Set;

public interface IDAO<T> {
    void create(T t);

    T getById(int id);
    Set<T> getAll();

    void delete(T t);
}
