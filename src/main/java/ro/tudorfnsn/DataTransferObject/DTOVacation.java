package ro.tudorfnsn.DataTransferObject;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    Long employeeId;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-mm-dd")
    Date leave;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-mm-dd")
    Date arrival;
    MotiveOfAbsence motive;
    String description;
}
