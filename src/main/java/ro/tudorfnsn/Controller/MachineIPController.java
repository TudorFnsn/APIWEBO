package ro.tudorfnsn.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tudorfnsn.Repository.MachineIPRepository;
import ro.tudorfnsn.Service.MachineIPService;

@RestController
@RequestMapping(value = "/machineip")
public class MachineIPController
{
    private MachineIPService machineIPService;

    @Autowired
    public MachineIPController(MachineIPService machineIPService)
    {
        this.machineIPService = machineIPService;
    }
}
