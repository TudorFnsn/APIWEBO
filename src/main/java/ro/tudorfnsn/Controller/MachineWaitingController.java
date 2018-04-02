package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tudorfnsn.DataTransferObject.DTOMachineWaiting;
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


}
