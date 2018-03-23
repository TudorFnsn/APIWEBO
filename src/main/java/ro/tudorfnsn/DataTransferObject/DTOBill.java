package ro.tudorfnsn.DataTransferObject;

import lombok.*;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.MachineDone;


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
    MachineDone machineDone;
    Integer timeSpentOn;
    List<Employee> employeeList;
    Date date;
    Float finalPrice;
}
