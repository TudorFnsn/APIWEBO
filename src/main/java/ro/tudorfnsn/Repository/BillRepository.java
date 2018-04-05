package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ro.tudorfnsn.Model.Bill;
import ro.tudorfnsn.Model.Machine;

import javax.transaction.Transactional;
import java.util.Date;

public interface BillRepository extends JpaRepository<Bill, Long>
{
    Bill findById(Long id);
    Bill findByDate(Date date);
    Bill findByMachine(Machine machine);


    //@Modifying
    //@Transactional
    Bill removeById(Long id);

    @Modifying
    @Transactional
    void deleteFirstById(Long id);

    // do findByDate
}
