package dk.cph.DAOs;

import dk.cph.entities.Course;

import java.util.Set;

/**
 * Purpose:
 *
 * @author: Jeppe Koch
 */
public class CourseDAO implements IDAO<Course> {
    @Override
    public void create(Course course) {

    }

    @Override
    public Course getById(int id) {
        return null;
    }

    @Override
    public Set<Course> getAll() {
        return Set.of();
    }

    @Override
    public void update(Course course) {

    }

    @Override
    public void delete(Course course) {

    }
}
