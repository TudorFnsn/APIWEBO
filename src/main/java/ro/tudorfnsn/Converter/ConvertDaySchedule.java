package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTODaySchedule;
import ro.tudorfnsn.Model.DaySchedule;
import ro.tudorfnsn.Model.Task;
import ro.tudorfnsn.Repository.EmployeeRepository;
import ro.tudorfnsn.Repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertDaySchedule implements ConverterInterface<DaySchedule, DTODaySchedule>
{

    private EmployeeRepository employeeRepository;
    private TaskRepository taskRepository;

    public ConvertDaySchedule(EmployeeRepository employeeRepository, TaskRepository taskRepository)
    {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public DTODaySchedule OneToDTO(DaySchedule daySchedule)
    {
        DTODaySchedule dtoDaySchedule = new DTODaySchedule();

        List<Long> tasksId = new ArrayList<>();

        for(Task task : daySchedule.getTaskList())
        {
            tasksId.add(task.getId());
        }

        dtoDaySchedule.setId(daySchedule.getId());
        dtoDaySchedule.setEmployeeId(daySchedule.getEmployee().getId());
        //dtoDaySchedule.setNews(daySchedule.getNews());
        dtoDaySchedule.setDate(daySchedule.getDate());
        dtoDaySchedule.setTaskIdList(tasksId);

        return dtoDaySchedule;
    }

    @Override
    public List<DTODaySchedule> ManyToDTO(List<DaySchedule> daySchedules)
    {
        List<DTODaySchedule> dtoDayScheduleList = new ArrayList<>();

        for(DaySchedule daySchedule : daySchedules)
            dtoDayScheduleList.add(OneToDTO(daySchedule));

        return dtoDayScheduleList;

    }

    @Override
    public DaySchedule OneToModel(DTODaySchedule dtoDaySchedule)
    {
        DaySchedule daySchedule = new DaySchedule();

        List<Task> tasks = new ArrayList<>();

        for (Long id: dtoDaySchedule.getTaskIdList())
        {
            tasks.add(taskRepository.findFirstById(id));
        }

        daySchedule.setEmployee(employeeRepository.findFirstById(dtoDaySchedule.getEmployeeId()));
        //daySchedule.setNews(dtoDaySchedule.getNews());
        daySchedule.setDate(dtoDaySchedule.getDate());
        daySchedule.setTaskList(tasks);

        return daySchedule;

    }

    @Override
    public List<DaySchedule> ManyToModel(List<DTODaySchedule> dtoDaySchedules)
    {
        List<DaySchedule> dayScheduleList = new ArrayList<>();

        for(DTODaySchedule dtoDaySchedule : dtoDaySchedules)
            dayScheduleList.add(OneToModel(dtoDaySchedule));

        return dayScheduleList;
    }
}
