package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertBill;
import ro.tudorfnsn.Repository.BillRepository;

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
}
