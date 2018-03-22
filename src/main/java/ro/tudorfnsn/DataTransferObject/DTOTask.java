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
    Integer startHour;
    Integer endHour;
    TextArea description;
}
