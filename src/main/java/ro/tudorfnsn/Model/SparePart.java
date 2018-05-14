package ro.tudorfnsn.Model;

import lombok.*;
import ro.tudorfnsn.Enumerable.Origin;
import ro.tudorfnsn.Model.Element.MechanicalElement;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sparePart")
@NoArgsConstructor
@Getter
@Setter
@ToString

public class SparePart extends MechanicalElement
{
    @Column
    private Float price;

    @Column
    private Integer quantity;

    @Column
    private Origin origin;

    //new
    //@ManyToMany(mappedBy = "sparePartsList",cascade = CascadeType.PERSIST)
    //private List<Machine> machineList;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "sparePartsList")
    private List<Machine> machineList;


    public SparePart(String picture, String name, String series, Float price, Integer quantity, Origin origin)
    {
        super(picture,name,series);
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

}
