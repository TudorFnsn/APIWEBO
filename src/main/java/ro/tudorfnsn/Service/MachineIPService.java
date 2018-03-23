package ro.tudorfnsn.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.DataTransferObject.DTOMachineIP;
import ro.tudorfnsn.Converter.ConvertMachineIP;
import ro.tudorfnsn.Model.MachineIP;
import ro.tudorfnsn.Repository.MachineIPRepository;

import java.util.List;

@Service
public class MachineIPService
{
    private MachineIPRepository machineIPRepository;
    private ConvertMachineIP convertMachineIP;

    @Autowired
    public MachineIPService(MachineIPRepository machineIPRepository, ConvertMachineIP convertMachineIP)
    {

        this.machineIPRepository = machineIPRepository;
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
}
