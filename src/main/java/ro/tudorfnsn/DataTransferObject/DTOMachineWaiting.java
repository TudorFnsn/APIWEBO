package ro.tudorfnsn.DataTransferObject;

import lombok.*;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Model.SparePart;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DTOMachineWaiting
{
    String picture;
    String name;
    String series;
    Status status;
    List<SparePart> sparePartList;
    Owner owner;
    Date arrivalDate;
}
