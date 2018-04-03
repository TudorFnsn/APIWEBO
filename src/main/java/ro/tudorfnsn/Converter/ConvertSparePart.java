package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOSparePart;
import ro.tudorfnsn.Model.SparePart;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertSparePart implements ConverterInterface<SparePart, DTOSparePart>
{
    @Override
    public DTOSparePart OneToDTO(SparePart sparePart)
    {
        DTOSparePart dtoSparePart = new DTOSparePart();

        dtoSparePart.setId(sparePart.getId());
        dtoSparePart.setPicture(sparePart.getPicture());
        dtoSparePart.setName(sparePart.getName());
        dtoSparePart.setSeries(sparePart.getSeries());
        dtoSparePart.setPrice(sparePart.getPrice());
        dtoSparePart.setQuantity(sparePart.getQuantity());
        dtoSparePart.setOrigin(sparePart.getOrigin());

        return dtoSparePart;
    }

    @Override
    public List<DTOSparePart> ManyToDTO(List<SparePart> spareParts)
    {
        List<DTOSparePart> dtoSparePartList = new ArrayList<>();

        for(SparePart sparePart: spareParts)
            dtoSparePartList.add(OneToDTO(sparePart));

        return dtoSparePartList;
    }

    @Override
    public SparePart OneToModel(DTOSparePart dtoSparePart)
    {
        SparePart sparePart = new SparePart();

        sparePart.setPicture(dtoSparePart.getPicture());
        sparePart.setName(dtoSparePart.getName());
        sparePart.setSeries(dtoSparePart.getSeries());
        sparePart.setPrice(dtoSparePart.getPrice());
        sparePart.setQuantity(dtoSparePart.getQuantity());
        sparePart.setOrigin(dtoSparePart.getOrigin());

        return sparePart;
    }

    @Override
    public List<SparePart> ManyToModel(List<DTOSparePart> dtoSpareParts)
    {
        List<SparePart> sparePartList = new ArrayList<>();

        for(DTOSparePart dtoSparePart : dtoSpareParts)
            sparePartList.add(OneToModel(dtoSparePart));

        return sparePartList;

    }
}
