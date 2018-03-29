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

}
