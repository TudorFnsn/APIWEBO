package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTOTask;
import ro.tudorfnsn.Service.TaskService;

import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskController
{
    private TaskService taskService;

    @Autowired

    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOTask> getAll()
    {
        List<DTOTask> dtoTaskList = taskService.getAllTasks();

        return dtoTaskList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTOTask dtoTask)
    {
        taskService.createTask(dtoTask);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTOTask getById(@PathVariable Long id)
    {
        DTOTask dtoTask = taskService.getById(id);

        return dtoTask;
    }

    @RequestMapping(value = "/getByStartHour/{startHour}", method = RequestMethod.GET)
    public List<DTOTask> getByStartHour(@PathVariable Integer startHour)
    {
        List<DTOTask> dtoTaskList = taskService.getByStartHour(startHour);

        return dtoTaskList;

        // SAU ASAAAA!!!
        //return taskService.getByStartHour(startHour);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        taskService.removeTask(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody DTOTask dtoTask)
    {
        taskService.update(id, dtoTask);
    }


}
