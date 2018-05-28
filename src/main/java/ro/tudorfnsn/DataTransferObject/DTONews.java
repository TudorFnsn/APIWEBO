package ro.tudorfnsn.DataTransferObject;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    Long id;
    String title;
    String picture;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-mm-dd")
    Date startDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-mm-dd")
    Date endDate;

}
