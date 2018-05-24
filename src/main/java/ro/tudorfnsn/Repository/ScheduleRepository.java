//package ro.tudorfnsn.Repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import ro.tudorfnsn.Model.Schedule;
//import ro.tudorfnsn.Model.Employee;
//
//import javax.transaction.Transactional;
//import java.util.Date;
//import java.util.List;
//
//public interface ScheduleRepository extends JpaRepository<Schedule, Long>
//{
//    Schedule findFirstById(Long id);
//    Schedule findFirstByEmployee(Employee employee);
//    //Schedule findFirstByNews(News news);
//
//    @Modifying
//    @Transactional
//    void deleteFirstById(Long id);
//}
