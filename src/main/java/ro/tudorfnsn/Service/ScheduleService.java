//package ro.tudorfnsn.Service;
//
//import ro.tudorfnsn.DataTransferObject.DTOSchedule;
//import ro.tudorfnsn.Model.Employee;
//import ro.tudorfnsn.Model.Schedule;
//import ro.tudorfnsn.Repository.ScheduleRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ro.tudorfnsn.Converter.ConvertSchedule;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class ScheduleService
//{
//    private ScheduleRepository scheduleRepository;
//    private ConvertSchedule convertSchedule;
//
//    @Autowired
//    public ScheduleService(ScheduleRepository scheduleRepository, ConvertSchedule convertSchedule)
//    {
//        this.scheduleRepository = scheduleRepository;
//        this.convertSchedule = convertSchedule;
//    }
//
//    public void createSchedule(DTOSchedule DTOSchedule)
//    {
//        Schedule schedule = convertSchedule.OneToModel(DTOSchedule);
//
//        scheduleRepository.save(schedule);
//    }
//
//    public List<DTOSchedule> getAllSchedules()
//    {
//        List<Schedule> scheduleList = scheduleRepository.findAll();
//
//        List<DTOSchedule> DTOScheduleList = convertSchedule.ManyToDTO(scheduleList);
//
//        return DTOScheduleList;
//    }
//
//    public DTOSchedule getById(Long id)
//    {
//        Schedule schedule = scheduleRepository.findFirstById(id);
//
//        DTOSchedule DTOSchedule = convertSchedule.OneToDTO(schedule);
//
//        return DTOSchedule;
//    }
//
//    public DTOSchedule getByEmployee(Employee employee)
//    {
//        Schedule schedule = scheduleRepository.findFirstByEmployee(employee);
//
//        DTOSchedule DTOSchedule = convertSchedule.OneToDTO(schedule);
//
//        return DTOSchedule;
//    }
//
////    public DTOSchedule getByNews(News news)
////    {
////        Schedule daySchedule = scheduleRepository.findFirstByNews(news);
////
////        DTOSchedule dtoDaySchedule = convertDaySchedule.OneToDTO(daySchedule);
////
////        return dtoDaySchedule;
////    }
//
////    public List<DTOSchedule> getByDate(Date date)
////    {
////        List<Schedule> scheduleList = scheduleRepository.findByDate(date);
////
////        List<DTOSchedule> DTOScheduleList = convertSchedule.ManyToDTO(scheduleList);
////
////        return DTOScheduleList;
////    }
//
//    public void removeSchedule(Long id)
//    {
//        scheduleRepository.deleteFirstById(id);
//    }
//
//    public void update(Long id, DTOSchedule dtoSchedule)
//    {
//        Schedule newSchedule = convertSchedule.OneToModel(dtoSchedule);
//
//        Schedule oldSchedule = scheduleRepository.findFirstById(id);
//
//        newSchedule.setId(oldSchedule.getId());
//
//        scheduleRepository.save(newSchedule);
//
//
//    }
//
//}
