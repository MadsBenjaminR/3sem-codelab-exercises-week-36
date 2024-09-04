package dk.cph.DAOs;

import dk.cph.entities.Course;

import java.util.Set;

public interface IDAO<T> {
    void create(T t);

    T getById(int id);

    Set<T> getAll();

    void delete(T t);

    void update(T t);
}
