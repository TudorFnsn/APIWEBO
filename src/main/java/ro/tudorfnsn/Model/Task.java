package ro.tudorfnsn.Model;

import lombok.*;
import ro.tudorfnsn.Enumerable.Completed;

import javax.persistence.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


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

    //@ManyToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @ManyToOne
    private Employee employee;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private  String startHour;

    @Column
    private String endHour;

    @Column
    private String descriptions;

    @Column
    private Completed completed;

    public Task(Employee employee, Date date, String startHour, String endHour, String descriptions, Completed completed)
    {
        this.employee = employee;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
        this.descriptions = descriptions;
        this.completed = completed;
    }
}
