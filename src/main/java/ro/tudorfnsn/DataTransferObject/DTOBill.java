package ro.tudorfnsn.DataTransferObject;

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
    Date date;
    Float finalPrice;
}
