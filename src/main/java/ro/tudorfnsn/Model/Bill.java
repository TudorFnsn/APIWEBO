package ro.tudorfnsn.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bill")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
// Bill doesn't have owner field because we take the owner from the machineDone
public class Bill
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(targetEntity = Machine.class, cascade = CascadeType.DETACH)
    private Machine machine;

    @Column
    private Integer timeSpentOn;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.DETACH)
    private List<Employee> employeeList;

    @Column
    private Float finalPrice;

    public Bill(Machine machine, List<Employee> employeeList, Integer timeSpentOn, Date date, Float finalPrice)
    {
        this.machine = machine;
        this.employeeList = employeeList;
        this.timeSpentOn = timeSpentOn;
        this.date = date;
        this.finalPrice = finalPrice;
    }

}
