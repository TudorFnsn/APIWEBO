package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertEmployee;
import ro.tudorfnsn.Converter.ConvertTask;
import ro.tudorfnsn.DataTransferObject.DTOEmployee;
import ro.tudorfnsn.DataTransferObject.DTOTask;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.Task;
import ro.tudorfnsn.Repository.TaskRepository;

import java.util.Date;
import java.util.List;

@Service
public class TaskService
{
    private TaskRepository taskRepository;
    private ConvertTask convertTask;
    private ConvertEmployee convertEmployee;

    @Autowired

    public TaskService(TaskRepository taskRepository, ConvertTask convertTask, ConvertEmployee convertEmployee)
    {
        this.taskRepository = taskRepository;
        this.convertTask = convertTask;
        this.convertEmployee = convertEmployee;
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

    public List<DTOTask> getByDate(Date date)
    {
        List<Task> taskList = taskRepository.findByDate(date);

        List<DTOTask> DTOTaskList = convertTask.ManyToDTO(taskList);

        return DTOTaskList;
    }

    public List<DTOTask> getByEmployee(Employee employee)
    {
        List<Task> taskList = taskRepository.findByEmployee(employee);

        List<DTOTask> dtoTaskList = convertTask.ManyToDTO(taskList);

        return dtoTaskList;
    }

}
