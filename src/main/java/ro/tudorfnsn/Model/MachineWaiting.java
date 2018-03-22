package ro.tudorfnsn.Model;


import lombok.*;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.Element.MechanicalMachineElement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="machineWaiting")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class MachineWaiting extends MechanicalMachineElement
{
    @Column
    private Date arrivalDate;

    public MachineWaiting(String picture, String name, String series, List<SparePart> sparePartList, String owner, Date arrivalDate)
    {
        super(picture, name, series, Status.WAITING, sparePartList, owner);
        this.arrivalDate = arrivalDate;
    }
}
