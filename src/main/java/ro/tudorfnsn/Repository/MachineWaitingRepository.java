package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.MachineWaiting;

import java.util.List;

public interface MachineWaitingRepository extends JpaRepository<MachineWaiting, Long>
{
    MachineWaiting findFirstById(Long id);
    MachineWaiting findFirstBySeries(String series);
    List<MachineWaiting> findByName(String name);
    List<MachineWaiting> findByStatus(Status status);
    List<MachineWaiting> findByOwner(String owner);
}
