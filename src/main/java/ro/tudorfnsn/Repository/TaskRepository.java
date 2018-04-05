package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>
{
    Task findFirstById (Long id);

    List<Task> findByStartHour (Integer startHour);

    void deleteFirstById (Long id);
}
