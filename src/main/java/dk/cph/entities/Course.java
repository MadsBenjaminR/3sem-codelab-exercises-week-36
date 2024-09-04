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

    @ManyToMany
    private Set<Student> student = new HashSet<>();

    @ManyToOne()
    private Teacher teacher;


public void addStudent(Student student) {
    this.student.add(student);

}
public void removeTeacher() {
    this.teacher.removeCourseFromTeacher(this);
    this.teacher = null;

}



}
