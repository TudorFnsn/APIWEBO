package ro.tudorfnsn.DataTransferObject;

import lombok.*;
import ro.tudorfnsn.Enumerable.Department;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class DTOEmployee
{
    Long id;
    String picture;
    String name;
    Department department;
    String position;
    //List<Long> taskListId;
    //List<Long> vacationListId;
}
