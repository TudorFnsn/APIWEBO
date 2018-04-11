package ro.tudorfnsn.Service;

import ro.tudorfnsn.Model.Bill;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.News;
import ro.tudorfnsn.Repository.DayScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertDaySchedule;
import ro.tudorfnsn.Repository.DayScheduleRepository;
import ro.tudorfnsn.Model.DaySchedule;
import ro.tudorfnsn.DataTransferObject.DTODaySchedule;

import java.util.Date;
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

    public DTODaySchedule getById(Long id)
    {
        DaySchedule daySchedule = dayScheduleRepository.findFirstById(id);

        DTODaySchedule dtoDaySchedule = convertDaySchedule.OneToDTO(daySchedule);

        return dtoDaySchedule;
    }

    public DTODaySchedule getByEmployee(Employee employee)
    {
        DaySchedule daySchedule = dayScheduleRepository.findFirstByEmployee(employee);

        DTODaySchedule dtoDaySchedule = convertDaySchedule.OneToDTO(daySchedule);

        return dtoDaySchedule;
    }

//    public DTODaySchedule getByNews(News news)
//    {
//        DaySchedule daySchedule = dayScheduleRepository.findFirstByNews(news);
//
//        DTODaySchedule dtoDaySchedule = convertDaySchedule.OneToDTO(daySchedule);
//
//        return dtoDaySchedule;
//    }

    public List<DTODaySchedule> getByDate(Date date)
    {
        List<DaySchedule> dayScheduleList = dayScheduleRepository.findByDate(date);

        List<DTODaySchedule> dtoDayScheduleList = convertDaySchedule.ManyToDTO(dayScheduleList);

        return dtoDayScheduleList;
    }

    public void removeDaySchedule(Long id)
    {
        dayScheduleRepository.deleteFirstById(id);
    }

    public void update(Long id, DTODaySchedule dtoDaySchedule)
    {
        DaySchedule newDaySchedule = convertDaySchedule.OneToModel(dtoDaySchedule);

        DaySchedule oldDaySchedule = dayScheduleRepository.findFirstById(id);

        newDaySchedule.setId(oldDaySchedule.getId());

        dayScheduleRepository.save(newDaySchedule);


    }

}
