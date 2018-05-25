package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTOTask;
import ro.tudorfnsn.Enumerable.Completed;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Service.TaskService;

import java.util.Date;
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

    //works
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOTask> getAll()
    {
        List<DTOTask> dtoTaskList = taskService.getAllTasks();

        return dtoTaskList;
    }

    //works
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTOTask dtoTask)
    {
        dtoTask.setCompleted(Completed.NO);
        taskService.createTask(dtoTask);
    }

    //works
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTOTask getById(@PathVariable Long id)
    {
        DTOTask dtoTask = taskService.getById(id);

        return dtoTask;
    }


    //works
    @RequestMapping(value = "/getByStartHour/{startHour}", method = RequestMethod.GET)
    public List<DTOTask> getByStartHour(@PathVariable String startHour)
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

    //works
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody DTOTask dtoTask)
    {
        taskService.update(id, dtoTask);
    }


    @RequestMapping(value = "/getByDate/{date}", method = RequestMethod.GET)
    public List<DTOTask> getByDate(@PathVariable Date date)
    {
        List<DTOTask> DTOTaskList = taskService.getByDate(date);

        return DTOTaskList;

    }

    @RequestMapping(value = "/getByEmployee/{employee}", method = RequestMethod.GET)
    public List<DTOTask> getByEmployee(@PathVariable Employee employee)
    {
        List<DTOTask> dtoTaskList = taskService.getByEmployee(employee);

        return dtoTaskList;
    }

}
