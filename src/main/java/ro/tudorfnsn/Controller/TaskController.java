package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

}
