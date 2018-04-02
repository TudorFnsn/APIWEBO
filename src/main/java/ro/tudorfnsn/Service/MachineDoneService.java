package ro.tudorfnsn.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertMachineDone;
import ro.tudorfnsn.Converter.ConvertMachineIP;
import ro.tudorfnsn.Repository.MachineDoneRepository;
import ro.tudorfnsn.Model.MachineDone;
import ro.tudorfnsn.DataTransferObject.DTOMachineDone;

import java.util.List;

@Service
public class MachineDoneService
{
    private MachineDoneRepository machineDoneRepository;
    private ConvertMachineDone convertMachineDone;

    @Autowired
    public MachineDoneService(MachineDoneRepository machineDoneRepository, ConvertMachineDone convertMachineDone)
    {
        this.machineDoneRepository = machineDoneRepository;
        this.convertMachineDone = convertMachineDone;
    }

    public void createMachineDone(DTOMachineDone dtoMachineDone)
    {
        MachineDone machineDone = convertMachineDone.OneToModel(dtoMachineDone);

        machineDoneRepository.save(machineDone);
    }

    public List<DTOMachineDone> getAllMachineDone()
    {
        List<MachineDone> machineDoneList = machineDoneRepository.findAll();

        List<DTOMachineDone> dtoMachineDoneList = convertMachineDone.ManyToDTO(machineDoneList);

        return dtoMachineDoneList;
    }

}
