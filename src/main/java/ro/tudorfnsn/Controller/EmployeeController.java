package ro.tudorfnsn.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTOEmployee;
import ro.tudorfnsn.Enumerable.Department;
import ro.tudorfnsn.Service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController
{
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    //works
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOEmployee> getAll()
    {
        List<DTOEmployee> dtoEmployeeList = employeeService.getAllEmployees();

        return dtoEmployeeList;
    }

    //works
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTOEmployee dtoEmployee)
    {
        employeeService.createEmployee(dtoEmployee);
    }

    //works
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTOEmployee getById(@PathVariable Long id)
    {
        DTOEmployee dtoEmployee = employeeService.getById(id);

        return dtoEmployee;
    }

    //works - am facut in repo getFirstByName de aia returneaza primul
    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public DTOEmployee getByName(@PathVariable String name)
    {
        DTOEmployee dtoEmployee = employeeService.getByName(name);

        return dtoEmployee;
    }


    //works
    @RequestMapping(value = "/getByDepartment/{department}", method = RequestMethod.GET)
    public List<DTOEmployee> getByDepartment(@PathVariable Department department)
    {
        List<DTOEmployee> dtoEmployeeList = employeeService.getByDepartement(department);

        return dtoEmployeeList;
    }

    //works
    @RequestMapping(value = "/getByPosition/{position}")
    public List<DTOEmployee> getByPosition(@PathVariable String position)
    {
        List<DTOEmployee> dtoEmployeeList = employeeService.getByPosition(position);

        return dtoEmployeeList;
    }

    //works
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        employeeService.removeEmployee(id);
    }


    //works
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody DTOEmployee dtoEmployee)
    {
        employeeService.update(id, dtoEmployee);
    }

}
