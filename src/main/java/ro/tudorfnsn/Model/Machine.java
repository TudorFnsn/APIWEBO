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
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;



    //new
    //previously it was only @ManyToMany
    //@ManyToMany(targetEntity = SparePart.class, cascade = CascadeType.DETACH)
    //@JoinTable(name = "machine_spare_parts_list", joinColumns = @JoinColumn(name = "machine_id", referencedColumnName = COLUMN_ID_A), inverseJoinColumns = @JoinColumn(name = COLUMN_REF_B, referencedColumnName = COLUMN_ID_B))
    //@JoinTable(name = "machine_spare_parts_list", joinColumns = { @JoinColumn(name = "machine_id") }, inverseJoinColumns = { @JoinColumn(name = "spare_parts_list_id") })

    /* THE ORIGINAL
    @ManyToMany(targetEntity = SparePart.class, cascade = CascadeType.DETACH)
    private List<SparePart> sparePartsList;
    */

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "machine_spare_parts_list", joinColumns = { @JoinColumn(name = "machine_id") }, inverseJoinColumns = { @JoinColumn(name = "spare_parts_list_id") })
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




////*********************
//package ro.tudorfnsn.Model;
//
//
//
//import lombok.*;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.hibernate.annotations.NaturalIdCache;
//import ro.tudorfnsn.Enumerable.Status;
//import ro.tudorfnsn.Model.Element.MechanicalElement;
//import ro.tudorfnsn.Model.Owner;
//import ro.tudorfnsn.Model.SparePart;
//
//import javax.persistence.*;
//import java.util.*;
//
//@Entity
//@Table
//@NaturalIdCache
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//public class Machine extends MechanicalElement
//{
//
//    @Column
//    protected Status status;
//
//    @Column
//    @Temporal(TemporalType.DATE)
//    private Date arrivalDate;
//
//
//
//    //new
//    //previously it was only @ManyToMany
//    //@ManyToMany(targetEntity = SparePart.class, cascade = CascadeType.DETACH)
//    //@JoinTable(name = "machine_spare_parts_list", joinColumns = @JoinColumn(name = "machine_id", referencedColumnName = COLUMN_ID_A), inverseJoinColumns = @JoinColumn(name = COLUMN_REF_B, referencedColumnName = COLUMN_ID_B))
//    //@JoinTable(name = "machine_spare_parts_list", joinColumns = { @JoinColumn(name = "machine_id") }, inverseJoinColumns = { @JoinColumn(name = "spare_parts_list_id") })
//
//    /* THE ORIGINAL
//    @ManyToMany(targetEntity = SparePart.class, cascade = CascadeType.DETACH)
//    private List<SparePart> sparePartsList;
//    */
//
////    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
////    @JoinTable(name = "machine_spare_parts_list", joinColumns = { @JoinColumn(name = "machine_id") }, inverseJoinColumns = { @JoinColumn(name = "spare_parts_list_id") })
////    private List<SparePart> sparePartsList;
//
//    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<MachineSparePart> sparePartsList = new ArrayList<>();
//
//    @ManyToOne
//    private Owner owner;
//
//    public Machine(String picture, String name, String series, Status status, List<MachineSparePart> sparePartsList, Owner owner, Date arrivalDate)
//    {
//        super(picture, name, series);
//
//        this.status = status;
//        this.sparePartsList = sparePartsList;
//        this.owner = owner;
//        this.arrivalDate = arrivalDate;
//
//    }
//
//    public Machine(String picture, String name, String series, Status status, List<MachineSparePart> sparePartsList, Owner owner)
//    {
//        super(picture, name, series);
//
//        this.status = status;
//        this.sparePartsList = sparePartsList;
//        this.owner = owner;
//
//    }
//
//    @Override
//    public boolean equals(Object o)
//    {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Machine machine = (Machine) o;
//        return Objects.equals(name, machine.name);
//    }
//
//    @Override
//    public int hashCode()
//    {
//        return Objects.hash(name);
//    }
//
//}


