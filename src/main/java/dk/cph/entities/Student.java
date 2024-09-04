package dk.cph.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

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
@Table(name = "student")
public class Student {


}
