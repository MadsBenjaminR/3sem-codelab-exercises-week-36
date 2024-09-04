package dk.cph.DAOs;

import dk.cph.entities.Student;

import java.util.Set;

/**
 * Purpose:
 *
 * @author: Jeppe Koch
 */
public class StudentDAO implements IDAO<Student> {
    @Override
    public void create(Student student) {

    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public Set<Student> getAll() {
        return Set.of();
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(Student student) {

    }
}
