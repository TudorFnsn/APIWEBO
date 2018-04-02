package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.MachineWaiting;
import ro.tudorfnsn.Model.Owner;

import java.util.List;

public interface MachineWaitingRepository extends JpaRepository<MachineWaiting, Long>
{
    MachineWaiting findFirstById(Long id);
    MachineWaiting findFirstBySeries(String series);
    List<MachineWaiting> findByName(String name);

    // nu e tare necesar findByStatus ca sunt frupate toate cu same status
    MachineWaiting findByStatus(Status status);
    MachineWaiting findByOwner(Owner owner);
    MachineWaiting deleteFirstById (Long id);
}
