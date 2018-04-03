package ro.tudorfnsn.DataTransferObject;

import lombok.*;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Model.SparePart;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class DTOMachineDone
{
    Long id;
    String picture;
    String name;
    String series;
    Status status;
    List<SparePart> sparePartList;
    Long owner_id;
}
