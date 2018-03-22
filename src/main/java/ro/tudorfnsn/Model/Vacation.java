package ro.tudorfnsn.Model;


import lombok.*;
import ro.tudorfnsn.Enumerable.MotiveOfAbsence;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Entity
@Table(name="vacation")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Vacation
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Employee.class)
    private Employee employee;

    @Column
    private Date leave;

    @Column
    private Date arrival;

    @Column
    private MotiveOfAbsence motive;

    @Column
    private TextArea description;

    public Vacation(Employee employee, Date leave, Date arrival, MotiveOfAbsence motive, TextArea description)
    {
        this.employee = employee;
        this.leave = leave;
        this.arrival = arrival;
        this.motive = motive;
        this.description = description;
    }
}
