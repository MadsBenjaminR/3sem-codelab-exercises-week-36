package dk.cph.DAOs;

import dk.cph.HibernateConfig;
import dk.cph.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Set;

/**
 * Purpose:
 *
 * @author: Jeppe Koch
 */
public class TeacherDAO implements IDAO<Teacher> {
    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    @Override
    public void create(Teacher teacher) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(teacher);
            em.getTransaction().commit();

        }
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
    public void delete(Teacher teacher) {

    }
}
