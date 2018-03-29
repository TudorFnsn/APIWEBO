package ro.tudorfnsn.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tudorfnsn.DataTransferObject.DTOEmployee;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOEmployee> getAll()
    {
        List<DTOEmployee> dtoEmployeeList = employeeService.getAllEmployees();

        return dtoEmployeeList;
    }
}
