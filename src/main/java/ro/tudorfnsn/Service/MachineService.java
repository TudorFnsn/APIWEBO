package ro.tudorfnsn.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertMachine;
import ro.tudorfnsn.DataTransferObject.DTOMachine;
import ro.tudorfnsn.DataTransferObject.DTOMachineWaiting;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.Machine;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Repository.MachineRepository;
import ro.tudorfnsn.Repository.OwnerRepository;
import ro.tudorfnsn.Repository.SparePartRepository;

import java.util.List;

@Service
public class MachineService
{
    private MachineRepository machineRepository;
    private OwnerRepository ownerRepository;
    private SparePartRepository sparePartRepository;
    private ConvertMachine convertMachine;

    @Autowired
    public MachineService(MachineRepository machineRepository, OwnerRepository ownerRepository,SparePartRepository sparePartRepository, ConvertMachine convertMachine)
    {

        this.machineRepository = machineRepository;
        this.ownerRepository = ownerRepository;
        this.sparePartRepository = sparePartRepository;
        this.convertMachine = convertMachine;
    }


    public void createMachineIP(DTOMachine dtoMachine)
    {
        Machine machine = convertMachine.OneToModel(dtoMachine);
        //machine.setOwner(ownerRepository.findFirstById(dtoMachine.getOwner_id()));
        machine.setStatus(Status.IN_PROGRESS);
        //machine.setArrivalDate(dtoMachine.getArrivalDate().getDate());

        machineRepository.save(machine);
    }

    public void createMachineWaiting(DTOMachine dtoMachine)
    {
        Machine machine = convertMachine.OneToModel(dtoMachine);
        //machine.setOwner(ownerRepository.findFirstById(dtoMachine.getOwner_id()));
        machine.setStatus(Status.WAITING);
        machineRepository.save(machine);
    }

    public List<DTOMachine> getAllMachine()
    {
        List<Machine> machineList = machineRepository.findAll();

        List<DTOMachine> dtoMachineList = convertMachine.ManyToDTO(machineList);

        return dtoMachineList;

    }

    public List<DTOMachine> getAllMachineByStatus(Status status)
    {
        List<Machine> machineList = machineRepository.findByStatus(status);

        List<DTOMachine> dtoMachineList = convertMachine.ManyToDTO(machineList);

        return dtoMachineList;

    }


    public DTOMachine getById(Long id)
    {
        Machine machine = machineRepository.findFirstById(id);

        DTOMachine dtoMachine = convertMachine.OneToDTO(machine);

        return dtoMachine;
    }

    public void removeMachine(Long id)
    {
        machineRepository.deleteFirstById(id);
    }

    public DTOMachine getBySeries(String series)
    {
        Machine machine = machineRepository.findFirstBySeries(series);

        DTOMachine dtoMachine = convertMachine.OneToDTO(machine);

        return dtoMachine;
    }

    public List<DTOMachine> getByName(String name)
    {
        List<Machine> machineList = machineRepository.findByName(name);

        List<DTOMachine> dtoMachineList = convertMachine.ManyToDTO(machineList);

        return dtoMachineList;
    }

    public List<DTOMachine> getByOwner(Owner owner)
    {
        List<Machine> machineList = machineRepository.findByOwner(owner);

        List<DTOMachine> dtoMachineList = convertMachine.ManyToDTO(machineList);

        return dtoMachineList;
    }

    public void update(Long id, DTOMachine dtomachine)
    {
        Machine newmachine = convertMachine.OneToModel(dtomachine);

        //newmachine.setOwner(ownerRepository.findFirstById(dtomachine.getOwner_id()));

        Machine oldmachine = machineRepository.findFirstById(id);

        newmachine.setId(oldmachine.getId());

        machineRepository.save(newmachine);
    }

    public void moveTo(Long id, Status status)
    {
        Machine oldmachine = machineRepository.findFirstById(id);

        oldmachine.setStatus(status);

        machineRepository.save(oldmachine);
    }


}
