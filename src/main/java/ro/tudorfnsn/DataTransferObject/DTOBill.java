package ro.tudorfnsn.DataTransferObject;

import lombok.*;
import ro.tudorfnsn.Model.Element.Machine;
import ro.tudorfnsn.Model.Employee;


import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DTOBill
{
    Long id;
    Machine machine;
    Integer timeSpentOn;
    List<Employee> employeeList;
    Date date;
    Float finalPrice;
}
