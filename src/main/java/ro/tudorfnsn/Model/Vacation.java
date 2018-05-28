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

    @ManyToOne
    private Employee employee;

    @Column
    @Temporal(TemporalType.DATE)
    private Date leave;

    @Column
    @Temporal(TemporalType.DATE)
    private Date arrival;

    @Column
    private MotiveOfAbsence motive;

    @Column
    private String descriptions;

    public Vacation(Employee employee, Date leave, Date arrival, MotiveOfAbsence motive, String descriptions)
    {

        this.employee = employee;
        this.leave = leave;
        this.arrival = arrival;
        this.motive = motive;
        this.descriptions = descriptions;
    }
}
