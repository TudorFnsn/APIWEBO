package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertTask;
import ro.tudorfnsn.DataTransferObject.DTOTask;
import ro.tudorfnsn.Model.Task;
import ro.tudorfnsn.Repository.TaskRepository;

import java.util.List;

@Service
public class TaskService
{
    private TaskRepository taskRepository;
    private ConvertTask convertTask;

    @Autowired

    public TaskService(TaskRepository taskRepository, ConvertTask convertTask)
    {
        this.taskRepository = taskRepository;
        this.convertTask = convertTask;
    }

    public void createTask(DTOTask dtoTask)
    {
        Task task = convertTask.OneToModel(dtoTask);

        taskRepository.save(task);
    }

    public List<DTOTask> getAllTasks()
    {
        List<Task> taskList = taskRepository.findAll();

        List<DTOTask> dtoTaskList = convertTask.ManyToDTO(taskList);

        return dtoTaskList;
    }

    public DTOTask getById(Long id)
    {
        Task task = taskRepository.findFirstById(id);

        DTOTask dtoTask = convertTask.OneToDTO(task);

        return dtoTask;
    }

    public List<DTOTask> getByStartHour(String startHour)
    {
        List<Task> taskList = taskRepository.findByStartHour(startHour);

        List<DTOTask> dtoTaskList = convertTask.ManyToDTO(taskList);

        return dtoTaskList;
    }

    public void removeTask(Long id)
    {
        taskRepository.deleteFirstById(id);
    }

    public void update(Long id, DTOTask dtoTask)
    {
        Task newTask = convertTask.OneToModel(dtoTask);

        Task oldTask = taskRepository.findFirstById(id);

        newTask.setId(oldTask.getId());

        taskRepository.save(newTask);
    }

}
