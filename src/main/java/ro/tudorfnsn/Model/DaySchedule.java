package ro.tudorfnsn.Model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Entity
@Table(name="schedule")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class DaySchedule
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    //@OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Employee.class)
    private Employee employee;


    @OneToOne
    private News news;


    @Column
    private Date date;

    @OneToMany(targetEntity = Task.class, cascade = CascadeType.ALL)
    private List<Task> taskList;




    public DaySchedule(Employee employee, Date date, List<Task> taskList)
    {
        this.employee = employee;
        this.date = date;
        this.taskList = taskList;

    }




}
