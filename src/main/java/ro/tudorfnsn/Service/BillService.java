package ro.tudorfnsn.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertBill;
import ro.tudorfnsn.DataTransferObject.DTOBill;
import ro.tudorfnsn.Model.Bill;
import ro.tudorfnsn.Model.Machine;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Repository.BillRepository;
import ro.tudorfnsn.Repository.EmployeeRepository;
import ro.tudorfnsn.Repository.MachineRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillService
{
    private BillRepository billRepository;
    private ConvertBill convertBill;
    private EmployeeRepository employeeRepository;
    private MachineRepository machineRepository;

    @Autowired
    public BillService(BillRepository billRepository, ConvertBill convertBill, EmployeeRepository employeeRepository, MachineRepository machineRepository)
    {
        this.billRepository = billRepository;
        this.convertBill = convertBill;
        this.employeeRepository = employeeRepository;
        this.machineRepository = machineRepository;
    }

    /*

    public void createBill(DTOBill dtoBill)
    {
        Bill bill = convertBill.OneToModel(dtoBill);

        List<Employee> employeeList = new ArrayList<>();

        bill.setMachine(machineRepository.findFirstById(dtoBill.getMachine_id()));

        for(Long id : dtoBill.getEmployeeIdList())
        {
            Employee employee = employeeRepository.findFirstById(id);

            employeeList.add(employee);
        }

        bill.setEmployeeList(employeeList);

        billRepository.save(bill);
    }


    public List<Long> getEmployeeIds(List<Employee> employees)
    {
        List<Long> employeeIds =  new ArrayList<>();

        for(Employee employee : employees)
            employeeIds.add(employee.getId());

        return employeeIds;
    }


    public List<DTOBill> getAllBills()
    {
        List<Bill> billList = billRepository.findAll();

        List<DTOBill> dtoBillList = convertBill.ManyToDTO(billList);

        //Machine machine = machineRepository.findFirstById(bi)

        for(int i = 0; i<billList.size(); i++)
        {
            dtoBillList.get(i).setEmployeeIdList(getEmployeeIds(billList.get(i).getEmployeeList()));
            dtoBillList.get(i).setMachine_id(billList.get(i).getMachine().getId());
        }

        return dtoBillList;
    }


*/
    public void createBill(DTOBill dtoBill)
    {
        Bill bill = convertBill.OneToModel(dtoBill);

        billRepository.save(bill);
    }

    public List<DTOBill> getAll()
    {
        List<Bill> billList = billRepository.findAll();
        List<DTOBill> dtoBillList = convertBill.ManyToDTO(billList);

        return dtoBillList;
    }


    public DTOBill getById(Long id)
    {
        Bill bill = billRepository.findById(id);

        DTOBill dtoBill = convertBill.OneToDTO(bill);

        return dtoBill;
    }

    public DTOBill getByDate(Date date)
    {
        Bill bill = billRepository.findByDate(date);

        DTOBill dtoBill = convertBill.OneToDTO(bill);

        return dtoBill;
    }

    public DTOBill getByMachineDone(Machine machine)
    {
        Bill bill = billRepository.findByMachine(machine);

        DTOBill dtoBill = convertBill.OneToDTO(bill);

        return dtoBill;
    }

    public void removeBill(Long id)
    {
        //billRepository.deleteById(id);
        //billRepository.removeById(id);

        //System.out.println("Relevant:" + id.getClass().getSimpleName());
        billRepository.deleteFirstById(id);


    }

    public void update(Long id, DTOBill dtoBill)
    {
        Bill newBill = convertBill.OneToModel(dtoBill);

        Bill oldBill = billRepository.findById(id);

        newBill.setId(oldBill.getId());

        billRepository.save(newBill);
    }


}
