package ro.tudorfnsn.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bill")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Bill
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(targetEntity = MachineDone.class, cascade = CascadeType.ALL)
    private MachineDone machineDone;

    @Column
    private Integer timeSpentOn;

    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    @Column
    private Float finalPrice;

    public Bill(MachineDone machineDone, List<Employee> employeeList, Integer timeSpentOn, Float finalPrice)
    {
        this.machineDone = machineDone;
        this.employeeList = employeeList;
        this.timeSpentOn = timeSpentOn;
        this.finalPrice = finalPrice;
    }

}
