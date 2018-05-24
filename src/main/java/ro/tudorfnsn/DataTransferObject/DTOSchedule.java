package ro.tudorfnsn.DataTransferObject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.News;
import ro.tudorfnsn.Model.Task;


import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class DTOSchedule
{
    Long id;
    Long employeeId;
    //News news;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    Date date;
    List<Long> taskIdList;
}
