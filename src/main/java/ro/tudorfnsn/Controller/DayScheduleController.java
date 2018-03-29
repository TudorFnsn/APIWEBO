package ro.tudorfnsn.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tudorfnsn.DataTransferObject.DTODaySchedule;
import ro.tudorfnsn.Service.DayScheduleService;

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

}
