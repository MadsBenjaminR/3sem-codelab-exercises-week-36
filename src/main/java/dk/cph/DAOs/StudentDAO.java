package dk.cph.DAOs;

import dk.cph.HibernateConfig;
import dk.cph.entities.Course;
import dk.cph.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Set;

/**
 * Purpose:
 *
 * @author: Jeppe Koch
 */
public class StudentDAO implements IDAO<Student> {
    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    @Override
    public void create(Student student) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
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
    public void delete(Student student) {

    }

    @Override
    public void update(Student student) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            Student foundStudent = em.find(Student.class, student.getId());

            if (foundStudent != null) {

                for (Course updatedCourse : student.getCourses()) {
                    boolean courseFound = false;
                    for (Course existingCourse : foundStudent.getCourses()) {

                        if (existingCourse.getId() == updatedCourse.getId()) {
                            existingCourse.setCourseName(updatedCourse.getCourseName());

                            courseFound = true;
                            break;
                        }
                    }

                    if (!courseFound) {
                        System.out.println("Course not found");
                    }
                }

                em.merge(foundStudent);
            } else {
                throw new IllegalArgumentException("Student not found");
            }

            em.getTransaction().commit();
        }
    }
}
