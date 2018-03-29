package ro.tudorfnsn.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tudorfnsn.DataTransferObject.DTOBill;
import ro.tudorfnsn.Service.BillService;

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
}
