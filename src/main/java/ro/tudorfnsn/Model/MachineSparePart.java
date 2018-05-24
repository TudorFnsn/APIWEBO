//package ro.tudorfnsn.Model;
//
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity(name = "MachineSparePart")
//@Table(name = "machine_sparepart")
//@Getter
//@Setter
//public class MachineSparePart
//{
//    @EmbeddedId
//    private MachineSparePartsId id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("machineId")
//    private Machine machine;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("sparePartId")
//    private SparePart sparePart;
//
//    @Column(name = "quantity")
//    private Long quantity;
//
//    public MachineSparePart()
//    {
//    }
//
//    public MachineSparePart(Machine machine, SparePart sparePart) {
//        this.machine = machine;
//        this.sparePart = sparePart;
//        this.id = new MachineSparePartsId(machine.getId(), sparePart.getId());
//
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        MachineSparePart that = (MachineSparePart) o;
//        return Objects.equals(machine, that.machine) &&
//                Objects.equals(sparePart, that.sparePart);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(machine, sparePart);
//    }
//}
