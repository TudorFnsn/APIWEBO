package ro.tudorfnsn.Model;



import lombok.*;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.Element.MechanicalElement;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Model.SparePart;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Machine extends MechanicalElement
{

    @Column
    protected Status status;

    @Column
    private Date arrivalDate;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinTable(name = "machine_part", joinColumns = {@JoinColumn(name = "machine_id")}, inverseJoinColumns = {@JoinColumn(name = "part_id")})
    private List<SparePart> sparePartsList;

    @ManyToOne
    private Owner owner;

    public Machine(String picture, String name, String series, Status status, List<SparePart> sparePartsList, Owner owner, Date arrivalDate)
    {
        super(picture, name, series);

        this.status = status;
        this.sparePartsList = sparePartsList;
        this.owner = owner;
        this.arrivalDate = arrivalDate;

    }

    public Machine(String picture, String name, String series, Status status, List<SparePart> sparePartsList, Owner owner)
    {
        super(picture, name, series);

        this.status = status;
        this.sparePartsList = sparePartsList;
        this.owner = owner;

    }

}
