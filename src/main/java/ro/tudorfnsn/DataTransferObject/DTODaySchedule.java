package ro.tudorfnsn.DataTransferObject;

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

public class DTODaySchedule
{
    Employee employee;
    News news;
    Date date;
    List<Task> taskList;
}
