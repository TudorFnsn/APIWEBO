//package ro.tudorfnsn.Converter;
//
//import org.springframework.stereotype.Component;
//import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
//import ro.tudorfnsn.DataTransferObject.DTOSchedule;
//import ro.tudorfnsn.Model.Task;
//import ro.tudorfnsn.Repository.EmployeeRepository;
//import ro.tudorfnsn.Repository.TaskRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class ConvertSchedule implements ConverterInterface<Schedule, DTOSchedule>
//{
//
//    private EmployeeRepository employeeRepository;
//    private TaskRepository taskRepository;
//
//    public ConvertSchedule(EmployeeRepository employeeRepository, TaskRepository taskRepository)
//    {
//        this.employeeRepository = employeeRepository;
//        this.taskRepository = taskRepository;
//    }
//
//    @Override
//    public DTOSchedule OneToDTO(Schedule schedule)
//    {
//        DTOSchedule DTOSchedule = new DTOSchedule();
//
//        List<Long> tasksId = new ArrayList<>();
//
//        for(Task task : schedule.getTaskList())
//        {
//            tasksId.add(task.getId());
//        }
//
//        DTOSchedule.setId(schedule.getId());
//        DTOSchedule.setEmployeeId(schedule.getEmployee().getId());
//        //DTOSchedule.setNews(schedule.getNews());
//        DTOSchedule.setTaskIdList(tasksId);
//
//        return DTOSchedule;
//    }
//
//    @Override
//    public List<DTOSchedule> ManyToDTO(List<Schedule> schedules)
//    {
//        List<DTOSchedule> DTOScheduleList = new ArrayList<>();
//
//        for(Schedule schedule : schedules)
//            DTOScheduleList.add(OneToDTO(schedule));
//
//        return DTOScheduleList;
//
//    }
//
//    @Override
//    public Schedule OneToModel(DTOSchedule DTOSchedule)
//    {
//        Schedule schedule = new Schedule();
//
//        List<Task> tasks = new ArrayList<>();
//
//        for (Long id: DTOSchedule.getTaskIdList())
//        {
//            tasks.add(taskRepository.findFirstById(id));
//        }
//
//        schedule.setEmployee(employeeRepository.findFirstById(DTOSchedule.getEmployeeId()));
//        //schedule.setNews(DTOSchedule.getNews());
//        schedule.setTaskList(tasks);
//
//        return schedule;
//
//    }
//
//    @Override
//    public List<Schedule> ManyToModel(List<DTOSchedule> DTOSchedules)
//    {
//        List<Schedule> scheduleList = new ArrayList<>();
//
//        for(DTOSchedule DTOSchedule : DTOSchedules)
//            scheduleList.add(OneToModel(DTOSchedule));
//
//        return scheduleList;
//    }
//}
