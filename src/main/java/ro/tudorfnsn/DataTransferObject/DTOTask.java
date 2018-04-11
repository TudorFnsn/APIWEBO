package ro.tudorfnsn.DataTransferObject;
import lombok.*;

import java.awt.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class DTOTask
{
    Long id;
    String startHour;
    String endHour;
    String description;
}
