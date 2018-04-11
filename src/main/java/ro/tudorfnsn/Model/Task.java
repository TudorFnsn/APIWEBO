package ro.tudorfnsn.Model;

import lombok.*;

import javax.persistence.*;
import java.awt.*;
import java.text.SimpleDateFormat;



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
    private  String startHour;

    @Column
    private String endHour;

    @Column
    private String description;

    public Task(String startHour, String endHour, String description)
    {
        this.startHour = startHour;
        this.endHour = endHour;
        this.description = description;
    }
}
