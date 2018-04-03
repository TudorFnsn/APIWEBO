package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOMachineDone;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.MachineDone;


import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertMachineDone implements ConverterInterface<MachineDone, DTOMachineDone>
{
    @Override
    public DTOMachineDone OneToDTO(MachineDone machineDone)
    {


        DTOMachineDone dtoMachineDone = new DTOMachineDone();

        dtoMachineDone.setId(machineDone.getId());
        dtoMachineDone.setPicture(machineDone.getPicture());
        dtoMachineDone.setName(machineDone.getName());
        dtoMachineDone.setSeries(machineDone.getSeries());
        dtoMachineDone.setStatus(Status.FINALIZED);
        dtoMachineDone.setSparePartList(machineDone.getSparePartsList());
        dtoMachineDone.setOwner(machineDone.getOwner());

        return dtoMachineDone;


    }

    @Override
    public List<DTOMachineDone> ManyToDTO(List<MachineDone> machineDoneList)
    {
        List<DTOMachineDone> dtoList = new ArrayList<>();

        for (MachineDone machineDone : machineDoneList)
        {
            dtoList.add(OneToDTO(machineDone));
        }

        return dtoList;

    }

    @Override
    public MachineDone OneToModel(DTOMachineDone dtoMachineDone)
    {
        MachineDone machineDone = new MachineDone();
        machineDone.setPicture(dtoMachineDone.getPicture());
        machineDone.setName(dtoMachineDone.getName());
        machineDone.setSeries(dtoMachineDone.getSeries());
        machineDone.setStatus(Status.IN_PROGRESS);
        machineDone.setSparePartsList(dtoMachineDone.getSparePartList());
        machineDone.setOwner(dtoMachineDone.getOwner());

        return machineDone;

    }

    @Override
    public List<MachineDone>ManyToModel(List<DTOMachineDone> dtoMachineDoneList)
    {
        List<MachineDone> machineDoneList = new ArrayList<>();

        for(DTOMachineDone dtoMachineDone : dtoMachineDoneList)
        {
            machineDoneList.add(OneToModel(dtoMachineDone));
        }

        return machineDoneList;

    }
}
