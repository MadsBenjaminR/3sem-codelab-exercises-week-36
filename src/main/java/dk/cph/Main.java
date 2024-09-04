package dk.cph;

import dk.cph.DAOs.CourseDAO;
import dk.cph.DAOs.StudentDAO;
import dk.cph.DAOs.TeacherDAO;
import dk.cph.entities.Course;
import dk.cph.entities.Student;
import dk.cph.entities.Teacher;

import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO(HibernateConfig.getEntityManagerFactory());
        TeacherDAO teacherDAO = new TeacherDAO();

        Teacher teacher = Teacher.builder()
                .email("john.doe@example.com") // Replace with actual email
                .name("John Doe")              // Replace with actual name
                .zoom("john.doe.zoom.us")     // Replace with actual Zoom link
                .build();

        Course artCourse = Course.builder()
                .courseName(CourseName.ART) // Use enum constant directly
                .build();

        Course sportCourse = Course.builder()
                .courseName(CourseName.SPORTS) // Use enum constant directly
                .build();
        Course course = Course.builder()
                .courseName(CourseName.SCIENCE) // Ensure this value exists in your CourseName enum
                .description("Science course focusing on physics and chemistry.")
                .startDate(LocalDate.of(2024, 3, 1))
                .endDate(LocalDate.of(2024, 9, 30))
                .build();

        Student student = Student.builder()
                .name("Charlie")
                .email("charliekkk@example.com")
                .build();


        teacher.addCourseToTeacher(artCourse);
        artCourse.setTeacher(teacher);

        teacherDAO.create(teacher);
        courseDAO.create(artCourse);


        //courseDAO.create(course);
        //studentDAO.create(student);


        /*student.addCourse(artCourse);
        student.addCourse(sportCourse);
        student.addCourse(course);

        studentDAO.update(student);
        */

        //student.setCourses(Set.of(sportCourse));

    }
}