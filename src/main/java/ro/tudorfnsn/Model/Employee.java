package ro.tudorfnsn.Model;

import lombok.*;
import ro.tudorfnsn.Enumerable.Department;
import ro.tudorfnsn.Model.Element.Element;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="employee")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employee extends Element
{

    @Column
    private String position;

    @Column
    private Department department;

//    @OneToMany(cascade = CascadeType.DETACH, targetEntity = Task.class)
//    private List<Task> tasks;
//
//    @OneToMany(cascade = CascadeType.DETACH, targetEntity = Vacation.class)
//    private List<Vacation> vacations;



    public Employee(String picture, String name, Department department, String position)
    {
        super(picture, name);
        this.department = department;
        this.position = position;
    }
}
