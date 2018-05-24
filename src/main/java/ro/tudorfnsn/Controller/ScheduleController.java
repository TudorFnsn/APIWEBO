//package ro.tudorfnsn.Controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import ro.tudorfnsn.DataTransferObject.DTOSchedule;
//import ro.tudorfnsn.Model.Employee;
//import ro.tudorfnsn.Service.ScheduleService;
//
//import java.util.Date;
//import java.util.List;
//
//
//@RestController
//@RequestMapping(value = "/schedule")
//public class ScheduleController
//{
//    private ScheduleService scheduleService;
//
//    @Autowired
//
//    public ScheduleController(ScheduleService scheduleService)
//    {
//        this.scheduleService = scheduleService;
//    }
//
//    //works
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public List<DTOSchedule> getAll()
//    {
//        List<DTOSchedule> DTOScheduleList = scheduleService.getAllSchedules();
//
//        return DTOScheduleList;
//    }
//
//    //works
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public void create(@RequestBody DTOSchedule DTOSchedule)
//    {
//        scheduleService.createSchedule(DTOSchedule);
//    }
//
//    //works
//    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
//    public DTOSchedule getById(@PathVariable Long id)
//    {
//        DTOSchedule DTOSchedule = scheduleService.getById(id);
//
//        return DTOSchedule;
//    }
//
////    @RequestMapping(value = "/getByDate/{date}", method = RequestMethod.GET)
////    public List<DTOSchedule> getByDate(@PathVariable Date date)
////    {
////        List<DTOSchedule> DTOScheduleList = scheduleService.getByDate(date);
////
////        return DTOScheduleList;
////
////    }
//
//    //works
//    @RequestMapping(value = "/getByEmployee/{employee}", method = RequestMethod.GET)
//    public DTOSchedule getByEmployee(@PathVariable Employee employee)
//    {
//        DTOSchedule DTOSchedule = scheduleService.getByEmployee(employee);
//
//        return DTOSchedule;
//    }
//
//
////    @RequestMapping(value = "/getByNews/{news}", method = RequestMethod.GET)
////    public DTOSchedule getByNews(@PathVariable News news)
////    {
////        DTOSchedule dtoDaySchedule = dayScheduleService.getByNews(news);
////
////        return dtoDaySchedule;
////    }
//
//    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
//    public void deleteById(@PathVariable Long id)
//    {
//        scheduleService.removeSchedule(id);
//    }
//
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    public void update(@PathVariable Long id, @RequestBody DTOSchedule dtoSchedule)
//    {
//        scheduleService.update(id, dtoSchedule);
//    }
//
//
//}
