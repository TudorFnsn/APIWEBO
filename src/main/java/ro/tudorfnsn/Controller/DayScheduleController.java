package ro.tudorfnsn.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTODaySchedule;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.News;
import ro.tudorfnsn.Service.DayScheduleService;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/dayschedule")
public class DayScheduleController
{
    private DayScheduleService dayScheduleService;

    @Autowired

    public DayScheduleController(DayScheduleService dayScheduleService)
    {
        this.dayScheduleService = dayScheduleService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTODaySchedule> getAll()
    {
        List<DTODaySchedule> dtoDayScheduleList = dayScheduleService.getAllDaySchedules();

        return dtoDayScheduleList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTODaySchedule dtoDaySchedule)
    {
        dayScheduleService.createDaySchedule(dtoDaySchedule);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTODaySchedule getById(@PathVariable Long id)
    {
        DTODaySchedule dtoDaySchedule = dayScheduleService.getById(id);

        return dtoDaySchedule;
    }

    @RequestMapping(value = "/getByDate/{date}", method = RequestMethod.GET)
    public List<DTODaySchedule> getByDate(@PathVariable Date date)
    {
        List<DTODaySchedule> dtoDayScheduleList = dayScheduleService.getByDate(date);

        return dtoDayScheduleList;

    }

    @RequestMapping(value = "/getByEmployee/{employee}", method = RequestMethod.GET)
    public DTODaySchedule getByEmployee(@PathVariable Employee employee)
    {
        DTODaySchedule dtoDaySchedule = dayScheduleService.getByEmployee(employee);

        return dtoDaySchedule;
    }

    @RequestMapping(value = "/getByNews/{news}", method = RequestMethod.GET)
    public DTODaySchedule getByNews(@PathVariable News news)
    {
        DTODaySchedule dtoDaySchedule = dayScheduleService.getByNews(news);

        return dtoDaySchedule;
    }

}
