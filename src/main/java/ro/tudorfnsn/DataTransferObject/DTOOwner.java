package ro.tudorfnsn.DataTransferObject;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DTOOwner
{
    Long id;
    String picture;
    String name;
    //List<MachineIP> machineIPList;
    //List<MachineDone> machineDoneList;
    //List<MachineWaiting> machineWaitingList;
}
