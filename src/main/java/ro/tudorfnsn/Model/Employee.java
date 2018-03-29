package ro.tudorfnsn.Model;

import lombok.*;
import ro.tudorfnsn.Enumerable.Department;
import ro.tudorfnsn.Model.Element.Element;


import javax.persistence.*;



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



    public Employee(String picture, String name, Department department, String position)
    {
        super(picture, name);
        this.department = department;
        this.position = position;

    }
}
