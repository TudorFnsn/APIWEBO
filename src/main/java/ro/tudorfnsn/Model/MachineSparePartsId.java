//package ro.tudorfnsn.Model;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//
//@Embeddable
//public class MachineSparePartsId implements Serializable
//{
//    @Column(name = "machine_id")
//    private Long machineId;
//
//    @Column(name = "sparePart_id")
//    private Long sparePartId;
//
//    public MachineSparePartsId()
//    {
//    }
//
//    public MachineSparePartsId(Long machineId, Long sparePartId)
//    {
//        this.machineId = machineId;
//        this.sparePartId = sparePartId;
//    }
//
//    public Long getMachineId() {
//        return machineId;
//    }
//
//    public void setMachineId(Long machineId) {
//        this.machineId = machineId;
//    }
//
//    public Long getSparePartId() {
//        return sparePartId;
//    }
//
//    public void setSparePartId(Long sparePartId) {
//        this.sparePartId = sparePartId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        MachineSparePartsId that = (MachineSparePartsId) o;
//        return Objects.equals(machineId, that.machineId) &&
//                Objects.equals(sparePartId, that.sparePartId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(machineId, sparePartId);
//    }
//}
