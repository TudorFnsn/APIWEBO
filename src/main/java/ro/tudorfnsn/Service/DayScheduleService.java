package ro.tudorfnsn.Service;

import ro.tudorfnsn.Repository.DayScheduleRepository;
import jdk.nashorn.internal.runtime.doubleconv.DtoaBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertDaySchedule;
import ro.tudorfnsn.Repository.DayScheduleRepository;
import ro.tudorfnsn.Model.DaySchedule;
import ro.tudorfnsn.DataTransferObject.DTODaySchedule;

import java.util.List;

@Service
public class DayScheduleService
{
    private DayScheduleRepository dayScheduleRepository;
    private ConvertDaySchedule convertDaySchedule;

    @Autowired
    public DayScheduleService(DayScheduleRepository dayScheduleRepository, ConvertDaySchedule convertDaySchedule)
    {
        this.dayScheduleRepository = dayScheduleRepository;
        this.convertDaySchedule = convertDaySchedule;
    }

    public void createDaySchedule(DTODaySchedule dtoDaySchedule)
    {
        DaySchedule daySchedule = convertDaySchedule.OneToModel(dtoDaySchedule);

        dayScheduleRepository.save(daySchedule);
    }

    public List<DTODaySchedule> getAllDaySchedules()
    {
        List<DaySchedule> dayScheduleList = dayScheduleRepository.findAll();

        List<DTODaySchedule> dtoDayScheduleList = convertDaySchedule.ManyToDTO(dayScheduleList);

        return dtoDayScheduleList;
    }
}
