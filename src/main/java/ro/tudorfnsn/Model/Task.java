package ro.tudorfnsn.Model;

import lombok.*;

import javax.persistence.*;
import java.awt.*;


@Entity
@Table(name="task")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer startHour;

    @Column
    private Integer endHour;

    @Column
    private TextArea description;

    public Task(Integer startHour, Integer endHour, TextArea description)
    {
        this.startHour = startHour;
        this.endHour = endHour;
        this.description = description;
    }
}
