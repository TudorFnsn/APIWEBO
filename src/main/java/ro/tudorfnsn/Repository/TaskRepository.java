package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ro.tudorfnsn.Model.Task;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>
{
    Task findFirstById (Long id);

    List<Task> findByStartHour (String startHour);

    @Modifying
    @Transactional
    void deleteFirstById (Long id);
}
