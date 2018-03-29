package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertEmployee;
import ro.tudorfnsn.DataTransferObject.DTOEmployee;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService
{
    private EmployeeRepository employeeRepository;
    private ConvertEmployee convertEmployee;

    @Autowired

    public EmployeeService(EmployeeRepository employeeRepository, ConvertEmployee convertEmployee)
    {
        this.employeeRepository = employeeRepository;
        this.convertEmployee = convertEmployee;
    }

    public void createEmployee(DTOEmployee dtoEmployee)
    {
        Employee employee = convertEmployee.OneToModel(dtoEmployee);

        employeeRepository.save(employee);
    }

    public List<DTOEmployee> getAllEmployees()
    {
        List<Employee> employeeList = employeeRepository.findAll();

        List<DTOEmployee> dtoEmployeeList = convertEmployee.ManyToDTO(employeeList);

        return dtoEmployeeList;
    }
}
