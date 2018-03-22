package ro.tudorfnsn.Model.Element;



import lombok.*;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.SparePart;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class MechanicalMachineElement extends MechanicalElement
{

    @Column
    private Status status;


    @ManyToMany(targetEntity = SparePart.class, cascade = CascadeType.ALL) // every machine has more than one sparepart and every sparepart can be located in more than one machine
    private List<SparePart> sparePartsList;

    @Column
    private String owner;

    public MechanicalMachineElement(String picture, String name, String series, Status status, List<SparePart> sparePartsList, String owner)
    {
        super(picture, name, series);

        this.status = status;
        this.sparePartsList = sparePartsList;
        this.owner = owner;

    }

}
