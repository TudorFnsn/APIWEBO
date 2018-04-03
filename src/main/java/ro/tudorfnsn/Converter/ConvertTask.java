package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOTask;
import ro.tudorfnsn.Model.Task;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertTask implements ConverterInterface<Task, DTOTask>
{
    @Override
    public DTOTask OneToDTO(Task task)
    {
        DTOTask dtoTask = new DTOTask();

        dtoTask.setId(task.getId());
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

        task.setStartHour(dtoTask.getStartHour());
        task.setEndHour(dtoTask.getEndHour());
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
