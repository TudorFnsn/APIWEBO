package ro.tudorfnsn.DataTransferObject;
import lombok.*;
import ro.tudorfnsn.Enumerable.MotiveOfAbsence;
import ro.tudorfnsn.Model.Employee;

import java.awt.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DTOVacation
{
    Long id;
    Employee employee;
    Date leave;
    Date arrival;
    MotiveOfAbsence motive;
    TextArea description;
}
