package ro.tudorfnsn.Converter;

import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import org.springframework.stereotype.Component;
import ro.tudorfnsn.DataTransferObject.DTOOwner;
import ro.tudorfnsn.Model.Owner;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertOwner implements ConverterInterface<Owner, DTOOwner>
{
    @Override
    public DTOOwner OneToDTO(Owner owner)
    {
        DTOOwner dtoOwner = new DTOOwner();

        dtoOwner.setId(owner.getId());
        dtoOwner.setPicture(owner.getPicture());
        dtoOwner.setName(owner.getName());
       // dtoOwner.setMachineIPList(owner.getMachineIPList());
       // dtoOwner.setMachineDoneList(owner.getMachineDoneList());
       // dtoOwner.setMachineWaitingList(owner.getMachineWaitingList());

        return dtoOwner;
    }

    @Override
    public List<DTOOwner> ManyToDTO(List<Owner> owners)
    {
        List<DTOOwner> dtoOwnerList = new ArrayList<>();

        for(Owner owner : owners)
            dtoOwnerList.add(OneToDTO(owner));

        return dtoOwnerList;

    }

    @Override
    public Owner OneToModel(DTOOwner dtoOwner)
    {
        Owner owner = new Owner();

        owner.setPicture(dtoOwner.getPicture());
        owner.setName(dtoOwner.getName());
       // owner.setMachineIPList(dtoOwner.getMachineIPList());
       // owner.setMachineDoneList(dtoOwner.getMachineDoneList());
       // owner.setMachineWaitingList(dtoOwner.getMachineWaitingList());

        return owner;

    }

    @Override
    public List<Owner> ManyToModel(List<DTOOwner> dtoOwners)
    {
        List<Owner> ownerList = new ArrayList<>();

        for(DTOOwner dtoOwner : dtoOwners)
            ownerList.add(OneToModel(dtoOwner));

        return ownerList;

    }
}
