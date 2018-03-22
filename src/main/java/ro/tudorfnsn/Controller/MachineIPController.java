package ro.tudorfnsn.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tudorfnsn.DataTransferObject.DTOMachineIP;
import ro.tudorfnsn.Service.MachineIPService;

import java.util.List;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOMachineIP> getAll()
    {
        List<DTOMachineIP> dtoMachineIPList = machineIPService.getAllMachineIP();

        return dtoMachineIPList;
    }
}
