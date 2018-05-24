package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOTask;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.Task;
import ro.tudorfnsn.Repository.EmployeeRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ConvertTask implements ConverterInterface<Task, DTOTask>
{

    private EmployeeRepository employeeRepository;

    public ConvertTask(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DTOTask OneToDTO(Task task)
    {
        DTOTask dtoTask = new DTOTask();

        dtoTask.setId(task.getId());
        dtoTask.setEmployeeId(task.getEmployee().getId());
        dtoTask.setDate(task.getDate());
        dtoTask.setCompleted(task.getCompleted());

        dtoTask.setStartHour(task.getStartHour());
        dtoTask.setEndHour(task.getEndHour());



        dtoTask.setDescription(task.getDescription());

        return dtoTask;

    }

    @Override
    public List<DTOTask> ManyToDTO(List<Task> tasks)
    {
        List<DTOTask> dtoTaskList = new ArrayList<>();

        for(Task task : tasks)
            dtoTaskList.add(OneToDTO(task));

        return dtoTaskList;
    }

    @Override
    public Task OneToModel(DTOTask dtoTask)
    {
        Task task = new Task();

        task.setEmployee(employeeRepository.findFirstById(dtoTask.getEmployeeId()));

        task.setDate(dtoTask.getDate());

        task.setStartHour(dtoTask.getStartHour());
        task.setEndHour(dtoTask.getEndHour());

        task.setCompleted(dtoTask.getCompleted());


        task.setDescription(dtoTask.getDescription());

        return task;

    }

    @Override
    public List<Task> ManyToModel(List<DTOTask> dtoTasks)
    {
        List<Task> taskList = new ArrayList<>();

        for(DTOTask dtoTask : dtoTasks)
            taskList.add(OneToModel(dtoTask));

        return taskList;
    }
}
