package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.Machine;
import ro.tudorfnsn.Model.Owner;


import javax.transaction.Transactional;
import java.util.List;

public interface MachineRepository extends JpaRepository<Machine, Long>
{
    // if there are no validation it's better to use findFirstBy... in case there are registered (by mistake ) a machine
    // with the same id



    Machine findFirstById(Long id);
    Machine findFirstBySeries(String series);
    List<Machine> findByName(String name);

    List<Machine> findByOwner(Owner owner);

    @Modifying
    @Transactional
    void deleteFirstById(Long id);
    List<Machine> findByStatus(Status status);
}
