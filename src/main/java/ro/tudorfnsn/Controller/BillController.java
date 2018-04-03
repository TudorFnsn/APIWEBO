package ro.tudorfnsn.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTOBill;
import ro.tudorfnsn.Model.Element.Machine;
import ro.tudorfnsn.Service.BillService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/bill")
public class BillController
{
    private BillService billService;

    @Autowired
    public BillController (BillService billService)
    {
        this.billService = billService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOBill> getAll()
    {
        List<DTOBill> dtoBillList = billService.getAllBills();

        return dtoBillList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTOBill dtoBill)
    {
        billService.createBill(dtoBill);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTOBill getById(@PathVariable Long id)
    {
        DTOBill dtoBill = billService.getById(id);

        return dtoBill;
    }

    @RequestMapping(value = "/getByDate/{date}", method = RequestMethod.GET)
    public DTOBill getByDate(@PathVariable Date date)
    {
        DTOBill dtoBill = billService.getByDate(date);

        return dtoBill;
    }

    @RequestMapping(value = "/getByMachineDone", method = RequestMethod.GET)
    public DTOBill getByMachineDone(@PathVariable Machine machine)
    {
        DTOBill dtoBill = billService.getByMachineDone(machine);

        return dtoBill;
    }
}
