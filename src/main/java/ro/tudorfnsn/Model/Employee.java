package ro.tudorfnsn.Model;

import lombok.*;
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



    public Employee(String picture, String name, String position)
    {
        super(picture, name);
        this.position = position;

    }
}
