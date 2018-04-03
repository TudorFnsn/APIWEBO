package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ro.tudorfnsn.Converter.ConvertMachineWaiting;
import ro.tudorfnsn.Converter.ConvertModels;
import ro.tudorfnsn.DataTransferObject.DTOMachineWaiting;
import ro.tudorfnsn.Model.MachineIP;
import ro.tudorfnsn.Model.MachineWaiting;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Repository.MachineIPRepository;
import ro.tudorfnsn.Repository.MachineWaitingRepository;

import java.util.List;

@Service
public class MachineWaitingService
{
    private MachineWaitingRepository machineWaitingRepository;
    private ConvertMachineWaiting convertMachineWaiting;
    private MachineIPRepository machineIPRepository;
    private ConvertModels convertModels;

    @Autowired
    public MachineWaitingService(MachineWaitingRepository machineWaitingRepository, MachineIPRepository machineIPRepository, ConvertMachineWaiting convertMachineWaiting)
    {
        this.machineWaitingRepository = machineWaitingRepository;
        this.machineIPRepository =machineIPRepository;
        this.convertMachineWaiting = convertMachineWaiting;
    }

    public void createMachineWaiting(DTOMachineWaiting dtoMachineWaiting)
    {
        MachineWaiting machineWaiting = convertMachineWaiting.OneToModel(dtoMachineWaiting);
        machineWaitingRepository.save(machineWaiting);
    }

    public List<DTOMachineWaiting> getAllMachineWaiting()
    {
        List<MachineWaiting> machineWaitingList = machineWaitingRepository.findAll();

        List<DTOMachineWaiting> dtoMachineWaitingList = convertMachineWaiting.ManyToDTO(machineWaitingList);

        return dtoMachineWaitingList;
    }

    public void removeMachineWaiting(Long id)
    {
        MachineWaiting machineWaiting = machineWaitingRepository.findFirstById(id);

        MachineIP machineIP = new MachineIP();

        convertModels.convertMachineWaitingToIP(machineWaiting,machineIP);

        machineIPRepository.save(machineIP);

        machineWaitingRepository.deleteFirstById(id);
    }

    public DTOMachineWaiting getById(Long id)
    {
        MachineWaiting machineWaiting = machineWaitingRepository.findFirstById(id);

        DTOMachineWaiting dtoMachineWaiting = convertMachineWaiting.OneToDTO(machineWaiting);

        return dtoMachineWaiting;
    }

    public DTOMachineWaiting getBySeries(String series)
    {
        MachineWaiting machineWaiting = machineWaitingRepository.findFirstBySeries(series);

        DTOMachineWaiting dtoMachineWaiting = convertMachineWaiting.OneToDTO(machineWaiting);

        return dtoMachineWaiting;
    }

    public List<DTOMachineWaiting> getByName(String name)
    {
        List<MachineWaiting> machineWaitingList = machineWaitingRepository.findByName(name);

        List<DTOMachineWaiting> dtoMachineWaitingList = convertMachineWaiting.ManyToDTO(machineWaitingList);

        return dtoMachineWaitingList;
    }

    public List<DTOMachineWaiting> getByOwner(Owner owner)
    {
        List<MachineWaiting> machineWaitingList = machineWaitingRepository.findByOwner(owner);

        List<DTOMachineWaiting> dtoMachineWaitingList = convertMachineWaiting.ManyToDTO(machineWaitingList);

        return dtoMachineWaitingList;
    }

}
