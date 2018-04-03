package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOEmployee;
import ro.tudorfnsn.Model.Employee;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertEmployee implements ConverterInterface<Employee, DTOEmployee>
{
    @Override
    public DTOEmployee OneToDTO(Employee employee)
    {
        DTOEmployee dtoEmployee = new DTOEmployee();

        dtoEmployee.setId(employee.getId());
        dtoEmployee.setPicture(employee.getPicture());
        dtoEmployee.setName(employee.getName());
        dtoEmployee.setDepartment(employee.getDepartment());
        dtoEmployee.setPosition(employee.getPosition());

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
