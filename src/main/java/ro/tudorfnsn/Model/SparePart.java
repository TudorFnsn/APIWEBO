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


//// *************
//
//
//package ro.tudorfnsn.Model;
//
//import lombok.*;
//import ro.tudorfnsn.Enumerable.Origin;
//import ro.tudorfnsn.Model.Element.MechanicalElement;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table(name = "sparePart")
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//
//public class SparePart extends MechanicalElement
//{
//    @Column
//    private Float price;
//
//    @Column
//    private Integer quantity;
//
//    @Column
//    private Origin origin;
//
//    //new
//    //@ManyToMany(mappedBy = "sparePartsList",cascade = CascadeType.PERSIST)
//    //private List<Machine> machineList;
//
////    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "sparePartsList")
////    private List<Machine> machineList;
//
//    @OneToMany(mappedBy = "spare_part", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<MachineSparePart> machineSparePartList = new ArrayList<>();
//
//
//    public SparePart(String picture, String name, String series, Float price, Integer quantity, Origin origin)
//    {
//        super(picture,name,series);
//        this.price = price;
//        this.quantity = quantity;
//        this.origin = origin;
//    }
//
//    public void addMachine(Machine machine)
//    {
//        MachineSparePart machineSparePart = new MachineSparePart(machine, this);
//        machineSparePartList.add(machineSparePart);
//        machine.getSparePartsList().add(machineSparePart);
//    }
//
//    public void removeTag(Machine machine)
//    {
//        for (Iterator<MachineSparePart> iterator = machineSparePartList.iterator();
//             iterator.hasNext(); ) {
//            MachineSparePart machineSparePart = iterator.next();
//
//            if (machineSparePart.getSparePart().equals(this) &&
//                    machineSparePart.getMachine().equals(machine)) {
//                iterator.remove();
//                machineSparePart.getMachine().getSparePartsList().remove(machineSparePart);
//                machineSparePart.setSparePart(null);
//                machineSparePart.setMachine(null);
//            }
//        }
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        SparePart sparePart = (SparePart) o;
//        return Objects.equals(name, sparePart.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
//
//}

