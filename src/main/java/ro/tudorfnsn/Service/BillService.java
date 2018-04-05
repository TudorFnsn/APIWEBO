package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertBill;
import ro.tudorfnsn.DataTransferObject.DTOBill;
import ro.tudorfnsn.Model.Bill;
import ro.tudorfnsn.Model.Element.Machine;
import ro.tudorfnsn.Repository.BillRepository;

import java.util.Date;
import java.util.List;

@Service
public class BillService
{
    private BillRepository billRepository;
    private ConvertBill convertBill;

    @Autowired
    public BillService(BillRepository billRepository, ConvertBill convertBill)
    {
        this.billRepository = billRepository;
        this.convertBill = convertBill;
    }

    public void createBill(DTOBill dtoBill)
    {
        Bill bill = convertBill.OneToModel(dtoBill);

        billRepository.save(bill);
    }

    public List<DTOBill> getAllBills()
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
        billRepository.deleteFirstBy(id);
    }

    public void update(Long id, DTOBill dtoBill)
    {
        Bill newBill = convertBill.OneToModel(dtoBill);

        Bill oldBill = billRepository.findById(id);

        newBill.setId(oldBill.getId());

        billRepository.save(newBill);
    }
}
