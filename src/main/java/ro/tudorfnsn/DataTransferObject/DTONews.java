package ro.tudorfnsn.DataTransferObject;
import lombok.*;

import java.awt.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class DTONews
{
    String title;
    Date startDate;
    Date endDate;
    TextArea description;
}
