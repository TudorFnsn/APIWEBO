package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ro.tudorfnsn.Converter.ConvertMachineWaiting;
import ro.tudorfnsn.DataTransferObject.DTOMachineWaiting;
import ro.tudorfnsn.Model.MachineWaiting;
import ro.tudorfnsn.Repository.MachineWaitingRepository;

import java.util.List;

@Service
public class MachineWaitingService
{
    private MachineWaitingRepository machineWaitingRepository;
    private ConvertMachineWaiting convertMachineWaiting;

    @Autowired
    public MachineWaitingService(MachineWaitingRepository machineWaitingRepository, ConvertMachineWaiting convertMachineWaiting)
    {
        this.machineWaitingRepository = machineWaitingRepository;
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

}
