package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ro.tudorfnsn.Model.DaySchedule;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.News;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface DayScheduleRepository extends JpaRepository<DaySchedule, Long>
{
    DaySchedule findFirstById(Long id);
    DaySchedule findFirstByEmployee(Employee employee);
    //DaySchedule findFirstByNews(News news);
    List<DaySchedule> findByDate (Date date);

    @Modifying
    @Transactional
    void deleteFirstById(Long id);
}
