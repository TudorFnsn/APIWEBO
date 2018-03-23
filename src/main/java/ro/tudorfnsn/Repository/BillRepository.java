package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Model.Bill;
import ro.tudorfnsn.Model.MachineDone;

import java.util.Date;

public interface BillRepository extends JpaRepository<Bill, Long>
{
    Bill findById(Long id);
    Bill findByDate(Date date);
    Bill findByMachineDone(MachineDone machineDone);

    // do findByDate
}
