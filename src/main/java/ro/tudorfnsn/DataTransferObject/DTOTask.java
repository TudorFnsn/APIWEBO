package ro.tudorfnsn.DataTransferObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ro.tudorfnsn.Enumerable.Completed;

import java.awt.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class DTOTask
{
    Long id;
    Long employeeId;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    Date date;
    String startHour;
    String endHour;
    String description;
    Completed completed;


}
