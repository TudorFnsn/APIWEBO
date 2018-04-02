package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.MachineDone;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Model.MachineIP;


import java.util.List;

public interface MachineDoneRepository extends JpaRepository<MachineDone, Long>
{
    // if there are no validation it's better to use findFirstBy... in case there are registered (by mistake ) a machine
    // with the same id

    MachineDone findFirstById(Long id);
    MachineDone findFirstBySeries(String series);
    List<MachineDone> findByName(String name);

    List<MachineDone> findByOwner(Owner owner);

    MachineDone deleteFirstById(Long id);
}
