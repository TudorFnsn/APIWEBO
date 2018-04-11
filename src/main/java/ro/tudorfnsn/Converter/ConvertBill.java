package ro.tudorfnsn.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOBill;
import ro.tudorfnsn.Model.Bill;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Repository.BillRepository;
import ro.tudorfnsn.Repository.EmployeeRepository;
import ro.tudorfnsn.Repository.MachineRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertBill implements ConverterInterface<Bill, DTOBill>
{
    private MachineRepository machineRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public ConvertBill(MachineRepository machineRepository, EmployeeRepository employeeRepository)
    {
        this.machineRepository = machineRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DTOBill OneToDTO(Bill bill)
    {
        DTOBill dtoBill = new DTOBill();

        List<Long> employeesId = new ArrayList<>();

        for(Employee employee : bill.getEmployeeList())
        {
            employeesId.add(employee.getId());
        }


        dtoBill.setId(bill.getId());
        dtoBill.setMachine_id(bill.getMachine().getId());
        dtoBill.setTimeSpentOn(bill.getTimeSpentOn());
        dtoBill.setEmployeeIdList(employeesId);
        //dtoBill.setEmployeeList(bill.getEmployeeList());
        dtoBill.setDate(bill.getDate());
        dtoBill.setFinalPrice(bill.getFinalPrice());

        return dtoBill;
    }

    @Override
    public List<DTOBill> ManyToDTO(List<Bill> bills)
    {
        List<DTOBill> dtoBillList = new ArrayList<>();

        for(Bill bill : bills)
            dtoBillList.add(OneToDTO(bill));

        return dtoBillList;
    }

    @Override
    public Bill OneToModel(DTOBill dtoBill)
    {
        Bill bill = new Bill();

        List<Employee> employees = new ArrayList<>();

        /*
        for(int i=0; i<dtoBill.getEmployeeIdList().size(); i++)
        {
            employees.add(employeeRepository.findFirstById(dtoBill.getId())
        }
        */


        for(Long id : dtoBill.getEmployeeIdList())
        {
            employees.add(employeeRepository.findFirstById(id));

        }

        //System.out.println(employees.size() + "hihi");



        /*
        for(Long id = ; id < dtoBill.getEmployeeIdList().size(); id++)
            employees.add(employeeRepository.findFirstById(id));
        */

       // Long id = dtoBill.getMachine_id();
       // bill.setMachine(machineRepository.findFirstById(dtoBill.getId()));
        bill.setMachine(machineRepository.findFirstById(dtoBill.getMachine_id()));
        bill.setTimeSpentOn(dtoBill.getTimeSpentOn());
        bill.setDate(dtoBill.getDate());
        bill.setEmployeeList(employees);
        //bill.setEmployeeList(dtoBill.getEmployeeList());
        bill.setFinalPrice(dtoBill.getFinalPrice());

        return bill;
    }

    @Override
    public List<Bill> ManyToModel(List<DTOBill> dtoBills)
    {
        List<Bill> billList = new ArrayList<>();

        for(DTOBill dtoBill : dtoBills)
            billList.add(OneToModel(dtoBill));

        return billList;
    }
}
