package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertOwner;
import ro.tudorfnsn.DataTransferObject.DTOOwner;
import ro.tudorfnsn.Model.Owner;
import ro.tudorfnsn.Repository.OwnerRepository;

import java.util.List;

@Service
public class OwnerService
{
    private OwnerRepository ownerRepository;
    private ConvertOwner convertOwner;

    @Autowired

    public OwnerService(OwnerRepository ownerRepository, ConvertOwner convertOwner)
    {
        this.ownerRepository = ownerRepository;
        this.convertOwner = convertOwner;
    }

    public void createOwner(DTOOwner dtoOwner)
    {
        Owner owner = convertOwner.OneToModel(dtoOwner);

        ownerRepository.save(owner);
    }

    public List<DTOOwner> getAllOwners()
    {
        List<Owner> ownerList = ownerRepository.findAll();

        List<DTOOwner> dtoOwnerList = convertOwner.ManyToDTO(ownerList);

        return dtoOwnerList;
    }

    public DTOOwner getById(Long id)
    {
        Owner owner = ownerRepository.findFirstById(id);

        DTOOwner dtoOwner = convertOwner.OneToDTO(owner);

        return dtoOwner;
    }

    public DTOOwner getByName(String name)
    {
        Owner owner = ownerRepository.findFirstByName(name);

        DTOOwner dtoOwner = convertOwner.OneToDTO(owner);

        return dtoOwner;
    }

}
