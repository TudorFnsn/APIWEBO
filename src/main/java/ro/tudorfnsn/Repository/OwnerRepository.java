package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ro.tudorfnsn.Model.Owner;

import javax.transaction.Transactional;

public interface OwnerRepository extends JpaRepository<Owner, Long>
{
    Owner findFirstById (Long id);
    Owner findFirstByName (String name);

    @Modifying
    @Transactional
    void deleteFirstById (Long id);

    //Owner findByMachineDoneList (MachineDone machineDone);
    //Owner findByMachineIPList (MachineIP machineIP);
    //Owner findByMachineWaitingList (MachineWaiting machineWaiting);
}
