package ro.tudorfnsn.Model;

import lombok.*;
import ro.tudorfnsn.Model.Element.Element;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="owner")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Owner extends Element
{
    //@OneToMany(targetEntity = MachineIP.class, cascade = CascadeType.ALL)
   // private List<MachineIP> machineIPList;

    //@OneToMany(targetEntity = MachineDone.class, cascade = CascadeType.ALL)
    //private List<MachineDone> machineDoneList;

    //@OneToMany(targetEntity = MachineWaiting.class, cascade = CascadeType.ALL)
    //private List<MachineWaiting> machineWaitingList;

    public Owner(String picture, String name)
    {
        super(picture, name);
        //this.machineIPList = machineIPList;
        //this.machineDoneList = machineDoneList;
       // this.machineWaitingList = machineWaitingList;
    }
}
