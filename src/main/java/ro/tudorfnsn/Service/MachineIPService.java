package ro.tudorfnsn.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertModels;
import ro.tudorfnsn.DataTransferObject.DTOMachineIP;
import ro.tudorfnsn.Converter.ConvertMachineIP;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.MachineDone;
import ro.tudorfnsn.Model.MachineIP;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Repository.MachineDoneRepository;
import ro.tudorfnsn.Repository.MachineIPRepository;

import java.util.List;

@Service
public class MachineIPService
{
    private MachineIPRepository machineIPRepository;
    private MachineDoneRepository machineDoneRepository;
    private ConvertMachineIP convertMachineIP;
    private ConvertModels convertModels;

    @Autowired
    public MachineIPService(MachineIPRepository machineIPRepository,MachineDoneRepository machineDoneRepository, ConvertMachineIP convertMachineIP)
    {

        this.machineIPRepository = machineIPRepository;
        this.machineDoneRepository = machineDoneRepository;
        this.convertMachineIP = convertMachineIP;
    }


    public void createMachineIP(DTOMachineIP dtoMachineIP)
    {
        MachineIP machineIP = convertMachineIP.OneToModel(dtoMachineIP);

        machineIPRepository.save(machineIP);
    }

    public List<DTOMachineIP> getAllMachineIP()
    {
        List<MachineIP> machineIPList = machineIPRepository.findAll();

        List<DTOMachineIP> dtoMachineIPList = convertMachineIP.ManyToDTO(machineIPList);

        return dtoMachineIPList;

    }

    public DTOMachineIP getById(Long id)
    {
        MachineIP machineIP = machineIPRepository.findById(id);

        DTOMachineIP dtoMachineIP = convertMachineIP.OneToDTO(machineIP);

        return dtoMachineIP;
    }

    public void removeMachineIP(Long id)
    {
        MachineIP machineIP = machineIPRepository.findById(id);

        MachineDone machineDone = new MachineDone();

        convertModels.convertMachineIPToDone(machineDone, machineIP);

        machineDoneRepository.save(machineDone);

        machineIPRepository.deleteFirstById(id);
    }

    public DTOMachineIP getBySeries(String series)
    {
        MachineIP machineIP = machineIPRepository.findBySeries(series);

        DTOMachineIP dtoMachineIP = convertMachineIP.OneToDTO(machineIP);

        return dtoMachineIP;
    }

    public List<DTOMachineIP> getByName(String name)
    {
        List<MachineIP> machineIPList = machineIPRepository.findByName(name);

        List<DTOMachineIP> dtoMachineIPList = convertMachineIP.ManyToDTO(machineIPList);

        return dtoMachineIPList;
    }

    public List<DTOMachineIP> getByOwner(Owner owner)
    {
        List<MachineIP> machineIPList = machineIPRepository.findByOwner(owner);

        List<DTOMachineIP> dtoMachineIPList = convertMachineIP.ManyToDTO(machineIPList);

        return dtoMachineIPList;
    }
}
