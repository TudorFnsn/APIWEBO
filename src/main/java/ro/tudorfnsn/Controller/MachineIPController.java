package ro.tudorfnsn.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTOMachineIP;
import ro.tudorfnsn.Model.Owner;
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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTOMachineIP dtoMachineIP)
    {
        machineIPService.createMachineIP(dtoMachineIP);
    }

    @RequestMapping(value = "/getBySeries/{series}", method = RequestMethod.GET)
    public DTOMachineIP getBySeries(@PathVariable String series)
    {
        DTOMachineIP dtoMachineIP = machineIPService.getBySeries(series);

        return dtoMachineIP;
    }

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public List<DTOMachineIP> getByName(@PathVariable String name)
    {
        List<DTOMachineIP> dtoMachineIPList = machineIPService.getByName(name);

        return dtoMachineIPList;

    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id)
    {
        machineIPService.removeMachineIP(id);

    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTOMachineIP getById(@PathVariable Long id)
    {
        DTOMachineIP dtoMachineIP = machineIPService.getById(id);

        return dtoMachineIP;
    }

    @RequestMapping(value = "/getByOwner/{owner}", method = RequestMethod.GET)
    public List<DTOMachineIP> getByOwner(@PathVariable Owner owner)
    {
        List<DTOMachineIP> dtoMachineIPList = machineIPService.getByOwner(owner);

        return dtoMachineIPList;
    }


}
