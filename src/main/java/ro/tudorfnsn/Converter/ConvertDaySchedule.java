package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTODaySchedule;
import ro.tudorfnsn.Model.DaySchedule;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertDaySchedule implements ConverterInterface<DaySchedule, DTODaySchedule>
{
    @Override
    public DTODaySchedule OneToDTO(DaySchedule daySchedule)
    {
        DTODaySchedule dtoDaySchedule = new DTODaySchedule();

        dtoDaySchedule.setEmployee(daySchedule.getEmployee());
        dtoDaySchedule.setNews(daySchedule.getNews());
        dtoDaySchedule.setDate(daySchedule.getDate());
        dtoDaySchedule.setTaskList(daySchedule.getTaskList());

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

        daySchedule.setEmployee(dtoDaySchedule.getEmployee());
        daySchedule.setNews(dtoDaySchedule.getNews());
        daySchedule.setDate(dtoDaySchedule.getDate());
        daySchedule.setTaskList(dtoDaySchedule.getTaskList());

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
