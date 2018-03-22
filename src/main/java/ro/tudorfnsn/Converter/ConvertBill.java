package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOBill;
import ro.tudorfnsn.Model.Bill;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertBill implements ConverterInterface<Bill, DTOBill>
{
    @Override
    public DTOBill OneToDTO(Bill bill)
    {
        DTOBill dtoBill = new DTOBill();

        dtoBill.setMachineDone(bill.getMachineDone());
        dtoBill.setTimeSpentOn(bill.getTimeSpentOn());
        dtoBill.setEmployeeList(bill.getEmployeeList());
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

        bill.setMachineDone(dtoBill.getMachineDone());
        bill.setTimeSpentOn(dtoBill.getTimeSpentOn());
        bill.setEmployeeList(dtoBill.getEmployeeList());
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
