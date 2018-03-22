package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.MachineIP;
import ro.tudorfnsn.DataTransferObject.DTOMachineIP;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertMachineIP implements ConverterInterface<MachineIP,DTOMachineIP>
{
    @Override
    public DTOMachineIP OneToDTO(MachineIP machineIP)
    {
        //set id needed???

        DTOMachineIP dtoMachineIP = new DTOMachineIP();
        dtoMachineIP.setPicture(machineIP.getPicture());
        dtoMachineIP.setName(machineIP.getName());
        dtoMachineIP.setSeries(machineIP.getSeries());
        dtoMachineIP.setStatus(Status.IN_PROGRESS);
        dtoMachineIP.setSparePartList(machineIP.getSparePartsList());
        dtoMachineIP.setOwner(machineIP.getOwner());

        return dtoMachineIP;


    }

    @Override
    public List<DTOMachineIP> ManyToDTO(List<MachineIP> machineIPList)
    {
        List<DTOMachineIP> dtoList = new ArrayList<>();

        for (MachineIP machineIP : machineIPList)
        {
            dtoList.add(OneToDTO(machineIP));
        }

        return dtoList;

    }

    @Override
    public MachineIP OneToModel(DTOMachineIP dtoMachineIP)
    {
        MachineIP machineIP = new MachineIP();
        machineIP.setPicture(dtoMachineIP.getPicture());
        machineIP.setName(dtoMachineIP.getName());
        machineIP.setSeries(dtoMachineIP.getSeries());
        machineIP.setStatus(Status.IN_PROGRESS);
        machineIP.setSparePartsList(dtoMachineIP.getSparePartList());
        machineIP.setOwner(dtoMachineIP.getOwner());

        return machineIP;

    }

    @Override
    public List<MachineIP>ManyToModel(List<DTOMachineIP> dtoMachineIPList)
    {
        List<MachineIP> machineIPList = new ArrayList<>();

        for(DTOMachineIP dtoMachineIP : dtoMachineIPList)
        {
            machineIPList.add(OneToModel(dtoMachineIP));
        }

        return machineIPList;

    }
}
