package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOMachineWaiting;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.MachineWaiting;


import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertMachineWaiting implements ConverterInterface<MachineWaiting, DTOMachineWaiting>
{
    @Override
    public DTOMachineWaiting OneToDTO(MachineWaiting machineWaiting)
    {
        DTOMachineWaiting dtoMachineWaiting = new DTOMachineWaiting();

        dtoMachineWaiting.setId(machineWaiting.getId());
        dtoMachineWaiting.setPicture(machineWaiting.getPicture());
        dtoMachineWaiting.setName(machineWaiting.getName());
        dtoMachineWaiting.setSeries(machineWaiting.getSeries());
        dtoMachineWaiting.setStatus(Status.WAITING);
        dtoMachineWaiting.setSparePartList(machineWaiting.getSparePartsList());
        dtoMachineWaiting.setOwner(machineWaiting.getOwner());

        return dtoMachineWaiting;

    }

    @Override
    public List<DTOMachineWaiting> ManyToDTO(List<MachineWaiting> machineWaitingList)
    {
        List<DTOMachineWaiting> dtoMachineWaitingList = new ArrayList<>();

        for(MachineWaiting machineWaiting : machineWaitingList)
            dtoMachineWaitingList.add(OneToDTO(machineWaiting));

        return dtoMachineWaitingList;
    }

    @Override
    public MachineWaiting OneToModel(DTOMachineWaiting dtoMachineWaiting)
    {
        MachineWaiting machineWaiting = new MachineWaiting();

        machineWaiting.setPicture(dtoMachineWaiting.getPicture());
        machineWaiting.setName(dtoMachineWaiting.getName());
        machineWaiting.setSeries(dtoMachineWaiting.getSeries());
        machineWaiting.setStatus(Status.WAITING);
        machineWaiting.setSparePartsList(dtoMachineWaiting.getSparePartList());
        machineWaiting.setOwner(dtoMachineWaiting.getOwner());

        return machineWaiting;
    }

    @Override
    public List<MachineWaiting> ManyToModel(List<DTOMachineWaiting> dtoMachineWaitingsList)
    {
        List<MachineWaiting> machineWaitingList = new ArrayList<>();

        for(DTOMachineWaiting dtoMachineWaiting :dtoMachineWaitingsList)
            machineWaitingList.add(OneToModel(dtoMachineWaiting));

        return machineWaitingList;

    }
}
