package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertEmployee;
import ro.tudorfnsn.Converter.ConvertTask;
import ro.tudorfnsn.Converter.ConvertVacation;
import ro.tudorfnsn.DataTransferObject.DTOEmployee;
import ro.tudorfnsn.DataTransferObject.DTOTask;
import ro.tudorfnsn.DataTransferObject.DTOVacation;
import ro.tudorfnsn.Enumerable.Department;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.Task;
import ro.tudorfnsn.Model.Vacation;
import ro.tudorfnsn.Repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService
{
    private EmployeeRepository employeeRepository;
    private ConvertEmployee convertEmployee;
    private ConvertTask convertTask;
    private ConvertVacation convertVacation;

    @Autowired

    public EmployeeService(EmployeeRepository employeeRepository, ConvertEmployee convertEmployee, ConvertTask convertTask, ConvertVacation convertVacation)
    {
        this.employeeRepository = employeeRepository;
        this.convertEmployee = convertEmployee;
        this.convertTask = convertTask;
        this.convertVacation = convertVacation;
        //System.out.println(employeeRepository.count());
    }

    public void createEmployee(DTOEmployee dtoEmployee)
    {
        Employee employee = convertEmployee.OneToModel(dtoEmployee);

        employeeRepository.save(employee);
    }

    public void createEmployeeManagement(DTOEmployee dtoEmployee)
    {
        Employee employee = convertEmployee.OneToModel(dtoEmployee);

        employee.setDepartment(Department.MANAGEMENT);

        employeeRepository.save(employee);
    }

    public void createEmployeeSales(DTOEmployee dtoEmployee)
    {
        Employee employee = convertEmployee.OneToModel(dtoEmployee);

        employee.setDepartment(Department.SALES);

        employeeRepository.save(employee);
    }

    public void createEmployeeService(DTOEmployee dtoEmployee)
    {
        Employee employee = convertEmployee.OneToModel(dtoEmployee);

        employee.setDepartment(Department.SERVICE);

        employeeRepository.save(employee);
    }

    public List<DTOEmployee> getAllEmployees()
    {
        List<Employee> employeeList = employeeRepository.findAll();

        List<DTOEmployee> dtoEmployeeList = convertEmployee.ManyToDTO(employeeList);

        return dtoEmployeeList;
    }

    public DTOEmployee getById(Long id)
    {
        Employee employee = employeeRepository.findFirstById(id);

        DTOEmployee dtoEmployee = convertEmployee.OneToDTO(employee);

        return dtoEmployee;
    }

    public List<DTOEmployee> getByDepartement(Department department)
    {
        List<Employee> employeeList = employeeRepository.findByDepartment(department);

        List<DTOEmployee> dtoEmployeeList = convertEmployee.ManyToDTO(employeeList);

        return dtoEmployeeList;
    }

    public List<DTOEmployee> getByPosition(String position)
    {
        List<Employee> employeeList = employeeRepository.findByPosition(position);

        List<DTOEmployee> dtoEmployeeList = convertEmployee.ManyToDTO(employeeList);

        return dtoEmployeeList;
    }

    public DTOEmployee getByName(String name)
    {
        Employee employee = employeeRepository.findFirstByName(name);

        DTOEmployee dtoEmployee = convertEmployee.OneToDTO(employee);

        return dtoEmployee;
    }

    public void removeEmployee(Long id)
    {
        employeeRepository.deleteFirstById(id);
    }

    public void update(Long id, DTOEmployee dtoEmployee)
    {
        Employee newEmployee = convertEmployee.OneToModel(dtoEmployee);

        Employee oldEmployee = employeeRepository.findFirstById(id);

        newEmployee.setId(oldEmployee.getId());

        employeeRepository.save(newEmployee);


    }

//    public List<DTOTask> getTasksOf(Long id)
//    {
//        Employee employee = employeeRepository.findFirstById(id);
//
//        List<Task> taskList = employee.getTasks();
//
//        List<DTOTask> dtoTaskList = convertTask.ManyToDTO(taskList);
//
//        return dtoTaskList;
//    }

//    public List<DTOVacation> getVacationOf(Long id)
//    {
//        Employee employee = employeeRepository.findFirstById(id);
//        List<Vacation> vacationList = employee.getVacations();
//        List<DTOVacation> dtoVacationList = convertVacation.ManyToDTO(vacationList);
//
//        return dtoVacationList;
//    }


}
