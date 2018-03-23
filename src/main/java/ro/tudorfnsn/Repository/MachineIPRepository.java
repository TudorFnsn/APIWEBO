package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.MachineIP;

import java.util.List;

public interface MachineIPRepository extends JpaRepository<MachineIP, Long>
{
    MachineIP findById(Long id);
    MachineIP findBySeries(String series);
    List<MachineIP> findByName(String name);

    // redundant
    MachineIP findByStatus(Status status);
    MachineIP findByOwner(String owner);
    MachineIP removeBy(Long id);


}
