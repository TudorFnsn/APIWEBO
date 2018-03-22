package ro.tudorfnsn.Model;


import lombok.*;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.Element.MechanicalMachineElement;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="machineDone")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

// machine finalized
public class MachineDone extends MechanicalMachineElement
{


  public MachineDone(String picture, String name, String series, List<SparePart> sparePartList, String owner)
  {
      super(picture, name, series, Status.FINALIZED, sparePartList, owner);

  }
}
