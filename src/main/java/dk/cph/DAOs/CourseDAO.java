package dk.cph.DAOs;

import dk.cph.entities.Course;
import jakarta.persistence.*;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Purpose:
 *
 * @author: Jeppe Koch
 */
public class CourseDAO implements IDAO<Course> {

    EntityManagerFactory emf;
    public CourseDAO(EntityManagerFactory emf) {
        this.emf = emf;

    }
    @Override
    public void create(Course course) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }

    }

    @Override
    public Course getById(int id) {
        try(EntityManager em= emf.createEntityManager()){
            TypedQuery<Course> query= em.createQuery("select u from Course u where u.id=:id", Course.class);
            query.setParameter("id",id);
            return query.getSingleResult();
        }
    }

    @Override
    public Set<Course> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Course>  query= em.createQuery("select u from Course u", Course.class);

            return query.getResultList().stream().collect(Collectors.toSet());

        }
    }

    @Override
    public void update(Course course) {
        try(EntityManager em= emf.createEntityManager()){
            em.getTransaction().begin();
            Course foundCourse = em.find(Course.class, course.getId());
            if (foundCourse != null) {
                foundCourse.setCourseName(course.getCourseName());

                em.merge(foundCourse);
            }else {
                throw new IllegalArgumentException("Course not found");
            }
            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(Course course) {

    }
}
