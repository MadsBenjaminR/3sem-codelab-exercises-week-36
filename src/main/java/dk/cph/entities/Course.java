package dk.cph.entities;

import dk.cph.CourseName;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Purpose:
 *
 * @author: Jeppe Koch
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private CourseName courseName;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> student;


    @ManyToOne()
    private Teacher teacher;

    public void addTeacherToCourse(Teacher teacher) {
        if (teacher != null) {
            this.teacher = teacher;
            teacher.getCourses().add(this);
        }

    }



public void addStudent(Student student) {
    this.student.add(student);

}
public void removeTeacher() {
    this.teacher.removeCourseFromTeacher(this);
    this.teacher = null;

}


    public static void main(String[] args) {
        Course course = new Course();
        course.setCourseName(CourseName.MATH);
    }
}
