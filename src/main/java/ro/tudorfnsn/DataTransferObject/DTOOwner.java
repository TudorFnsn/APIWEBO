package ro.tudorfnsn.DataTransferObject;

import lombok.*;
import ro.tudorfnsn.Model.MachineDone;
import ro.tudorfnsn.Model.MachineIP;
import ro.tudorfnsn.Model.MachineWaiting;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DTOOwner
{
    String picture;
    String name;
    List<MachineIP> machineIPList;
    List<MachineDone> machineDoneList;
    List<MachineWaiting> machineWaitingList;
}
