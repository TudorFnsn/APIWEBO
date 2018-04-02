package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTOMachineDone;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Service.MachineDoneService;

import java.util.List;

@RestController
@RequestMapping(value = "/machinedone")
public class MachineDoneController
{
    private MachineDoneService machineDoneService;

    @Autowired
    public MachineDoneController(MachineDoneService machineDoneService)
    {
        this.machineDoneService = machineDoneService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOMachineDone> getAll()
    {
        List<DTOMachineDone> dtoMachineDoneList = machineDoneService.getAllMachineDone();

        return dtoMachineDoneList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTOMachineDone dtoMachineDone)
    {
        machineDoneService.createMachineDone(dtoMachineDone);
    }

    @RequestMapping(value = "/getBySeries/{series}", method = RequestMethod.GET)
    public DTOMachineDone getBySeries(@PathVariable String series)
    {
        DTOMachineDone dtoMachineDone = machineDoneService.getBySeries(series);

        return dtoMachineDone;
    }

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public List<DTOMachineDone> getByName(@PathVariable String name)
    {
        List<DTOMachineDone> dtoMachineDoneList = machineDoneService.getByName(name);

        return dtoMachineDoneList;
    }

    @RequestMapping(value = "/getByOwner/{owner}", method = RequestMethod.GET)
    public List<DTOMachineDone> getByOwner(Owner owner)
    {
        List<DTOMachineDone> dtoMachineDoneList = machineDoneService.getByOwner(owner);

        return dtoMachineDoneList;
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTOMachineDone getById(Long id)
    {
        DTOMachineDone dtoMachineDone = machineDoneService.getById(id);

        return dtoMachineDone;
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id)
    {
        machineDoneService.removeMachineDone(id);
    }
}
