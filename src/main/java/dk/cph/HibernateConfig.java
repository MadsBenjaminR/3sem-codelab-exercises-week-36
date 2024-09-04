package dk.cph;

import jakarta.persistence.EntityManagerFactory;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.imageio.spi.ServiceRegistry;
import java.awt.*;
import java.lang.module.Configuration;
import java.util.Properties;

/**
 * Purpose:
 *
 * @author: Jeppe Koch
 */

    @NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
    public class HibernateConfig {

        private static EntityManagerFactory entityManagerFactory;

        private static EntityManagerFactory buildEntityFactoryConfigDev() {
            try {
                Configuration configuration = new Configuration();

                Properties props = new Properties();

                props.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/points?currentSchema=public");
                props.put("hibernate.connection.username", "postgres");
                props.put("hibernate.connection.password", "postgres");
                props.put("hibernate.show_sql", "true"); // show sql in console
                props.put("hibernate.format_sql", "true"); // format sql in console
                props.put("hibernate.use_sql_comments", "true"); // show sql comments in console

                props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"); // dialect for postgresql
                props.put("hibernate.connection.driver_class", "org.postgresql.Driver"); // driver class for postgresql
                props.put("hibernate.archive.autodetection", "class"); // hibernate scans for annotated classes
                props.put("hibernate.current_session_context_class", "thread"); // hibernate current session context
                props.put("hibernate.hbm2ddl.auto", "create-drop"); // hibernate creates tables based on entities
                // props.put("hibernate.hbm2ddl.auto", "update"); // hibernate creates tables based on entities


                return getEntityManagerFactory(configuration, props);
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        private static EntityManagerFactory setupHibernateConfigTest() {
            try {
                Configuration configuration = new Configuration();
                Properties props = new Properties();
                props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                props.put("hibernate.connection.driver_class", "org.testcontainers.jdbc.ContainerDatabaseDriver");
                props.put("hibernate.connection.url", "jdbc:tc:postgresql:15.3-alpine3.18:///test-db");
                props.put("hibernate.connection.username", "postgres");
                props.put("hibernate.connection.password", "postgres");
                props.put("hibernate.archive.autodetection", "class");
                props.put("hibernate.show_sql", "true");
                props.put("hibernate.hbm2ddl.auto", "create-drop");
                return getEntityManagerFactory(configuration, props);
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        private static EntityManagerFactory getEntityManagerFactory(Configuration configuration, Properties props) {
            configuration.setProperties(props);

            getAnnotationConfiguration(configuration);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate Java Config serviceRegistry created");

            SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
            return sf.unwrap(EntityManagerFactory.class);
        }

        private static void getAnnotationConfiguration(Configuration configuration) {
            configuration.addAnnotatedClass(Point.class);
        }

        public static EntityManagerFactory getEntityManagerFactory(boolean isTest) {
            if (isTest) return setupHibernateConfigTest();
            return buildEntityFactoryConfigDev();
        }
    }
}
