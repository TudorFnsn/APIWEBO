package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTOMachineWaiting;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Service.MachineWaitingService;

import java.util.List;

@RestController
@RequestMapping(value = "/machinewaiting")
public class MachineWaitingController
{
    private MachineWaitingService machineWaitingService;


    @Autowired
    public MachineWaitingController(MachineWaitingService machineWaitingService)
    {
        this.machineWaitingService = machineWaitingService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOMachineWaiting> getAll()
    {
        List<DTOMachineWaiting> dtoMachineWaitingList = machineWaitingService.getAllMachineWaiting();

        return dtoMachineWaitingList;
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id)
    {
        machineWaitingService.removeMachineWaiting(id);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTOMachineWaiting getById(Long id)
    {
        DTOMachineWaiting dtoMachineWaiting = machineWaitingService.getById(id);

        return dtoMachineWaiting;
    }

    @RequestMapping(value = "/getByOwner/{owner}", method = RequestMethod.GET)
    public List<DTOMachineWaiting> getByOwner(Owner owner)
    {
        List<DTOMachineWaiting> dtoMachineWaitingList = machineWaitingService.getByOwner(owner);

        return dtoMachineWaitingList;
    }

    @RequestMapping(value = "/getBySeries/{series}", method = RequestMethod.GET)
    public DTOMachineWaiting getBySeries(String series)
    {
        DTOMachineWaiting dtoMachineWaiting = machineWaitingService.getBySeries(series);

        return dtoMachineWaiting;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTOMachineWaiting dtoMachineWaiting)
    {
        machineWaitingService.createMachineWaiting(dtoMachineWaiting);
    }

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public List<DTOMachineWaiting> getByName(String name)
    {
        List<DTOMachineWaiting> dtoMachineWaitingList = machineWaitingService.getByName(name);

        return dtoMachineWaitingList;
    }




}
