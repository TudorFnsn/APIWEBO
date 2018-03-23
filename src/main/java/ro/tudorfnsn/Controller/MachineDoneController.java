package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tudorfnsn.DataTransferObject.DTOMachineDone;
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

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<DTOMachineDone> getAll()
    {
        List<DTOMachineDone> dtoMachineDoneList = machineDoneService.getAllMachineDone();

        return dtoMachineDoneList;
    }
}
