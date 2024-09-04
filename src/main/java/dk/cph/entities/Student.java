package dk.cph.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity autogenerator id
    private Integer id;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(unique = true)
    private String email;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    //sikre at den hopper ind på de metoder før den gemmer.
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @ManyToMany(mappedBy = "student")
    private Set<Course> courses;

    public void addCourse(Course course){
        course.setCourse(this);
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        course.setCourse(this);
        this.courses.remove(course);
    }








}
