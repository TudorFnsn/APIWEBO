package ro.tudorfnsn.Converter;


import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOMachine;
import ro.tudorfnsn.Model.Machine;
import ro.tudorfnsn.Model.SparePart;
import ro.tudorfnsn.Repository.OwnerRepository;
import ro.tudorfnsn.Repository.SparePartRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertMachine implements ConverterInterface<Machine,DTOMachine>
{
    private SparePartRepository sparePartRepository;
    private OwnerRepository ownerRepository;

    public ConvertMachine(SparePartRepository sparePartRepository, OwnerRepository ownerRepository)
    {
        this.sparePartRepository = sparePartRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public DTOMachine OneToDTO(Machine machine)
    {
        //set id needed???

        DTOMachine dtoMachine = new DTOMachine();

        List<Long> sparePartsId = new ArrayList<>();

        for( SparePart sparePart  : machine.getSparePartsList())
        {
            sparePartsId.add(sparePart.getId());
        }

        dtoMachine.setId(machine.getId());
        dtoMachine.setPicture(machine.getPicture());
        dtoMachine.setName(machine.getName());
        dtoMachine.setSeries(machine.getSeries());
        dtoMachine.setStatus(machine.getStatus());
        dtoMachine.setSparePartIdList(sparePartsId);
        //dtoMachine.setSparePartList(machine.getSparePartList());
        //dtoMachine.setOwner_id(machine.getOwner().getId());
        //DateFormat newDateFormat = new SimpleDateFormat("yyyy--dd");
        dtoMachine.setArrivalDate(machine.getArrivalDate());
        dtoMachine.setOwner_id(machine.getOwner().getId());
        //dtoMachine.setArrivalDate(newDateFormat.format(machine.getArrivalDate()));

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

        List<SparePart> sparePartList = new ArrayList<>();

        for(Long id : dtoMachine.getSparePartIdList())
        {
            sparePartList.add(sparePartRepository.findFirstById(id));
        }


        machine.setPicture(dtoMachine.getPicture());
        machine.setName(dtoMachine.getName());
        machine.setSeries(dtoMachine.getSeries());
        machine.setStatus(dtoMachine.getStatus());
        machine.setSparePartsList(sparePartList);
        //DateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        machine.setArrivalDate(dtoMachine.getArrivalDate());
        machine.setOwner(ownerRepository.findFirstById(dtoMachine.getOwner_id()));

        /*
        try
        {
            machine.setArrivalDate(newDateFormat.parse(dtoMachine.getArrivalDate()));
        }
        catch (Exception error)
        {
            System.out.println("INCORECT DATE");
        }
        */
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
