package ro.tudorfnsn.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.tudorfnsn.Enumerable.Status;
import ro.tudorfnsn.Model.MachineDone;
import ro.tudorfnsn.Model.MachineIP;
import ro.tudorfnsn.Model.MachineWaiting;

@Component
public class ConvertModels
{
    private MachineIP machineIP;
    private MachineDone machineDone;
    private MachineWaiting machineWaiting;


    /*
    public ConvertModels(MachineIP machineIP, MachineDone machineDone, MachineWaiting machineWaiting)
    {
        this.machineIP = machineIP;
        this.machineDone = machineDone;
        this.machineWaiting = machineWaiting;
    }
    */

    public void convertMachineIPToDone(MachineDone machineDone, MachineIP machineIP)
    {
        machineDone.setName(machineIP.getName());
        machineDone.setPicture(machineIP.getPicture());
        machineDone.setSeries(machineIP.getSeries());
        machineDone.setStatus(Status.FINALIZED);
        machineDone.setSparePartsList(machineIP.getSparePartsList());
        machineDone.setOwner(machineIP.getOwner());

    }

    public void convertMachineWaitingToIP(MachineWaiting machineWaiting, MachineIP machineIP)
    {
        machineIP.setName(machineWaiting.getName());
        machineIP.setPicture(machineWaiting.getPicture());
        machineIP.setSeries(machineWaiting.getSeries());
        machineIP.setStatus(Status.IN_PROGRESS);
        machineIP.setSparePartsList(machineWaiting.getSparePartsList());
        machineIP.setOwner(machineWaiting.getOwner());
    }
}
