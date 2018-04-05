package ro.tudorfnsn.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTOMachine;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Service.MachineService;

import java.util.List;

@RestController
@RequestMapping(value = "/machine")
public class MachineController
{
    private MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService)
    {
        this.machineService = machineService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOMachine> getAll()
    {
        List<DTOMachine> dtoMachineList = machineService.getAllMachine();

        return dtoMachineList;
    }

    @RequestMapping(value = "/createIP", method = RequestMethod.POST)
    public void createIP(@RequestBody DTOMachine dtoMachine)
    {
        machineService.createMachineIP(dtoMachine);
    }

    @RequestMapping(value = "/createWait", method = RequestMethod.POST)
    public void createWaiting(@RequestBody DTOMachine dtoMachine)
    {
        machineService.createMachineWaiting(dtoMachine);
    }

    @RequestMapping(value = "/getByStatus/{status}", method = RequestMethod.GET)
    public List<DTOMachine> getByStatus(@PathVariable Status status)
    {
        List<DTOMachine> dtoMachineList = machineService.getAllMachineByStatus(status);

        return dtoMachineList;
    }

    @RequestMapping(value = "/getBySeries/{series}", method = RequestMethod.GET)
    public DTOMachine getBySeries(@PathVariable String series)
    {
        DTOMachine dtoMachine = machineService.getBySeries(series);

        return dtoMachine;
    }

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public List<DTOMachine> getByName(@PathVariable String name)
    {
        List<DTOMachine> dtoMachineList = machineService.getByName(name);

        return dtoMachineList;

    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id)
    {
        machineService.removeMachine(id);

    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTOMachine getById(@PathVariable Long id)
    {
        DTOMachine dtoMachine = machineService.getById(id);

        return dtoMachine;
    }

    @RequestMapping(value = "/getByOwner/{owner}", method = RequestMethod.GET)
    public List<DTOMachine> getByOwner(@PathVariable Owner owner)
    {
        List<DTOMachine> dtoMachineList = machineService.getByOwner(owner);

        return dtoMachineList;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody DTOMachine dtoMachine)
    {
        machineService.update(id, dtoMachine);
    }

    @RequestMapping(value = "/moveTo/{id}", method = RequestMethod.POST)
    public void move(@PathVariable Long id, @RequestBody Status status)
    {
        machineService.moveTo(id, status);
    }







}
