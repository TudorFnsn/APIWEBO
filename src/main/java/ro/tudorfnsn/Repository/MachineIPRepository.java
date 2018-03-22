package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.MachineIP;
import ro.tudorfnsn.Model.MachineWaiting;

import java.util.List;

public interface MachineIPRepository extends JpaRepository<MachineIP, Long>
{
    MachineIP findById(Long id);
    MachineIP findBySeries(String series);
    List<MachineIP> findByName(String name);
    List<MachineIP> findByStatus(Status status);
    List<MachineIP> findByOwner(String owner);
    MachineIP removeBy(Long id);


}
