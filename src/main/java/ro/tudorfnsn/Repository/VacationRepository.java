package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Enumerable.MotiveOfAbsence;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.Vacation;

import java.util.Date;
import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long>
{
    Vacation findFirstById (Long id);

    Vacation findFirstByEmployee(Employee employee);

    List<Vacation> findByMotive (MotiveOfAbsence motiveOfAbsence);

    List<Vacation> findByLeave (Date leave);

    Vacation deleteFirstById (Long id);
}
