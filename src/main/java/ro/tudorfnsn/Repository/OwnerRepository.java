package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long>
{
    Owner findFirstById (Long id);
    Owner findFirstByName (String name);
    void deleteFirstById (Long id);

    //Owner findByMachineDoneList (MachineDone machineDone);
    //Owner findByMachineIPList (MachineIP machineIP);
    //Owner findByMachineWaitingList (MachineWaiting machineWaiting);
}
