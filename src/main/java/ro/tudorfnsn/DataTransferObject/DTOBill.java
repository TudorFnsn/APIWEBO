package ro.tudorfnsn.DataTransferObject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ro.tudorfnsn.Model.Machine;


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
    Long machine_id;
    Integer timeSpentOn;
    List<Long> employeeIdList;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    Date date;
    Float finalPrice;
}
