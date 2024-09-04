package dk.cph.DAOs;

import dk.cph.entities.Teacher;

import java.util.Set;

/**
 * Purpose:
 *
 * @author: Jeppe Koch
 */
public class TeacherDAO implements IDAO<Teacher> {
    @Override
    public void create(Teacher teacher) {

    }

    @Override
    public Teacher getById(int id) {
        return null;
    }

    @Override
    public Set<Teacher> getAll() {
        return Set.of();
    }

    @Override
    public void update(Teacher teacher) {

    }

    @Override
    public void delete(Teacher teacher) {

    }
}
