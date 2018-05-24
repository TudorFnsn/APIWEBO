package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOEmployee;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.Task;
import ro.tudorfnsn.Model.Vacation;
import ro.tudorfnsn.Repository.TaskRepository;
import ro.tudorfnsn.Repository.VacationRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertEmployee implements ConverterInterface<Employee, DTOEmployee>
{
    private TaskRepository taskRepository;
    private VacationRepository vacationRepository;

    public ConvertEmployee(TaskRepository taskRepository, VacationRepository vacationRepository)
    {
        this.taskRepository = taskRepository;
        this.vacationRepository = vacationRepository;
    }

    @Override
    public DTOEmployee OneToDTO(Employee employee)
    {
        DTOEmployee dtoEmployee = new DTOEmployee();

//        List<Long> taskListId = new ArrayList<>();
//        List<Long> vacationListId = new ArrayList<>();
//
//        for(Task task : employee.getTasks())
//        {
//            taskListId.add(task.getId());
//        }
//
//        for(Vacation vacation: employee.getVacations())
//        {
//            vacationListId.add(vacation.getId());
//        }

        dtoEmployee.setId(employee.getId());
        dtoEmployee.setPicture(employee.getPicture());
        dtoEmployee.setName(employee.getName());
        dtoEmployee.setDepartment(employee.getDepartment());
        dtoEmployee.setPosition(employee.getPosition());
        //dtoEmployee.setTaskListId(taskListId);
        //dtoEmployee.setVacationListId(vacationListId);

        return dtoEmployee;
    }

    @Override
    public List<DTOEmployee> ManyToDTO(List<Employee> employees)
    {
        List<DTOEmployee> dtoEmployeeList = new ArrayList<>();

        for(Employee employee: employees)
            dtoEmployeeList.add(OneToDTO(employee));

        return dtoEmployeeList;
    }

    @Override
    public Employee OneToModel(DTOEmployee dtoEmployee)
    {
        Employee employee = new Employee();

//        List<Task> taskList = new ArrayList<>();
//        List<Vacation> vacationList = new ArrayList<>();
//
//        for(Long id: dtoEmployee.getTaskListId())
//        {
//            taskList.add(taskRepository.findFirstById(id));
//        }
//
//        for(Long id : dtoEmployee.getVacationListId())
//        {
//            vacationList.add(vacationRepository.findFirstById(id));
//        }

        employee.setPicture(dtoEmployee.getPicture());
        employee.setName(dtoEmployee.getName());
        employee.setDepartment(dtoEmployee.getDepartment());
        employee.setPosition(dtoEmployee.getPosition());

        return employee;
    }

    @Override
    public List<Employee> ManyToModel(List<DTOEmployee> dtoEmployees)
    {
        List<Employee> employeeList = new ArrayList<>();

        for(DTOEmployee dtoEmployee : dtoEmployees)
            employeeList.add(OneToModel(dtoEmployee));

        return employeeList;
    }
}
