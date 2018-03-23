package ro.tudorfnsn.Model;

import lombok.*;
import org.springframework.stereotype.Component;

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

    @OneToOne(targetEntity = MachineDone.class, cascade = CascadeType.ALL)
    private MachineDone machineDone;

    @Column
    private Integer timeSpentOn;

    @Column
    private Date date;

    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    @Column
    private Float finalPrice;

    public Bill(MachineDone machineDone, List<Employee> employeeList, Integer timeSpentOn, Date date, Float finalPrice)
    {
        this.machineDone = machineDone;
        this.employeeList = employeeList;
        this.timeSpentOn = timeSpentOn;
        this.date = date;
        this.finalPrice = finalPrice;
    }

}
