package dk.cph;

import dk.cph.entities.Course;
import dk.cph.entities.Student;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Course artCourse = Course.builder().courseName(CourseName.valueOf("ART")).build();
        Student student = Student.builder().name("james").courses(Set.of(artCourse)).email("email.com").build();


    }
}