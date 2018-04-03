package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOMachine;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.Element.Machine;
import ro.tudorfnsn.Model.Element.Machine;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertMachine implements ConverterInterface<Machine,DTOMachine>
{
    @Override
    public DTOMachine OneToDTO(Machine machine)
    {
        //set id needed???

        DTOMachine dtoMachine = new DTOMachine();

        dtoMachine.setId(machine.getId());
        dtoMachine.setPicture(machine.getPicture());
        dtoMachine.setName(machine.getName());
        dtoMachine.setSeries(machine.getSeries());
        dtoMachine.setStatus(machine.getStatus());
        dtoMachine.setSparePartList(machine.getSparePartsList());
        //dtoMachine.setSparePartList(machine.getSparePartList());
        dtoMachine.setOwner_id(machine.getOwner().getId());
        dtoMachine.setArrivalDate(machine.getArrivalDate());

        return dtoMachine;


    }

    @Override
    public List<DTOMachine> ManyToDTO(List<Machine> machineList)
    {
        List<DTOMachine> dtoList = new ArrayList<>();

        for (Machine machine : machineList)
        {
            dtoList.add(OneToDTO(machine));
        }

        return dtoList;

    }

    @Override
    public Machine OneToModel(DTOMachine dtoMachine)
    {
        Machine machine = new Machine();
        machine.setPicture(dtoMachine.getPicture());
        machine.setName(dtoMachine.getName());
        machine.setSeries(dtoMachine.getSeries());
        machine.setStatus(dtoMachine.getStatus());
        machine.setSparePartsList(dtoMachine.getSparePartList());
        machine.setArrivalDate(dtoMachine.getArrivalDate());
        //machine.setSparePartList(dtoMachine.getSparePartList());
        //machine.setOwner(dtoMachine.getOwner());

        return machine;

    }

    @Override
    public List<Machine>ManyToModel(List<DTOMachine> dtoMachineList)
    {
        List<Machine> machineList = new ArrayList<>();

        for(DTOMachine dtoMachine : dtoMachineList)
        {
            machineList.add(OneToModel(dtoMachine));
        }

        return machineList;

    }
}
