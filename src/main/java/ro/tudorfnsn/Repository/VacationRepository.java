package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ro.tudorfnsn.Enumerable.MotiveOfAbsence;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.Vacation;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long>
{
    Vacation findFirstById (Long id);

    List<Vacation> findByEmployee(Employee employee);

    List<Vacation> findByMotive (MotiveOfAbsence motiveOfAbsence);

    List<Vacation> findByLeave (Date leave);

    @Modifying
    @Transactional
    void deleteFirstById (Long id);
}
