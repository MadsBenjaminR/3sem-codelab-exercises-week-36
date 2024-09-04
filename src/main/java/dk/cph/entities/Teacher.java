package dk.cph.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Purpose:
 *
 * @author: Jeppe Koch
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String name;
    private String zoom;
    @OneToMany(mappedBy = "Course")
    private Set<Course> courses;

    public void addTeacher(Course course) {
        course.setTeacher(this);
        this.courses.add(course);
    }

    public void removeCourseFromTeacher(Course course) {
        course.removeTeacher();
        this.courses.remove(course);
    }

}