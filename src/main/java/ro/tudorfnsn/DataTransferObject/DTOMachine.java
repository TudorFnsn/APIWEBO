package ro.tudorfnsn.DataTransferObject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Model.SparePart;

import java.util.Date;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DTOMachine
{
    Long id;
    String picture;
    String name;
    String series;
    Status status;
    List<Long> sparePartIdList;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    Date arrivalDate;
    Long owner_id;

}
