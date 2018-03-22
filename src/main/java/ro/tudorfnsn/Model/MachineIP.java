package ro.tudorfnsn.Model;


import lombok.*;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.Element.MechanicalMachineElement;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="machineIP")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

// machine in progress
public class MachineIP extends MechanicalMachineElement
{


    public MachineIP(String picture, String name, String series, List<SparePart> sparePartList, String owner)
    {
        super(picture, name, series, Status.IN_PROGRESS, sparePartList, owner);
    }


}
