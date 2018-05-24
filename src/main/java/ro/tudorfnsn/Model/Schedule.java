//package ro.tudorfnsn.Model;
//
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//
//
//@Entity
//@Table(name="schedule")
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//
//public class Schedule
//{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//
//    //@OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
////    @OneToOne(cascade = CascadeType.DETACH, targetEntity = Employee.class)
////    private Employee employee;
//
//
//
//    @OneToMany(targetEntity = Task.class, cascade = CascadeType.ALL)
//    private List<Task> taskList;
//
//
//
//
//    public Schedule(Employee employee, List<Task> taskList)
//    {
//
//        this.taskList = taskList;
//
//    }
//
//
//
//
//}
