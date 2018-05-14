package ro.tudorfnsn.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertSparePart;
import ro.tudorfnsn.DataTransferObject.DTOSparePart;
import ro.tudorfnsn.Enumerable.Origin;
import ro.tudorfnsn.Model.SparePart;
import ro.tudorfnsn.Repository.SparePartRepository;

import java.util.List;

@Service
public class SparePartService
{
    private SparePartRepository sparePartRepository;
    private ConvertSparePart convertSparePart;

    @Autowired

    public SparePartService(SparePartRepository sparePartRepository, ConvertSparePart convertSparePart)
    {
        this.sparePartRepository = sparePartRepository;
        this.convertSparePart = convertSparePart;
    }

    public void createSparePart(DTOSparePart dtoSparePart)
    {
        SparePart sparePart = convertSparePart.OneToModel(dtoSparePart);

        sparePartRepository.save(sparePart);
    }

    public void createSparePartRomania(DTOSparePart dtoSparePart)
    {
        SparePart sparePart = convertSparePart.OneToModel(dtoSparePart);
        sparePart.setOrigin(Origin.ROMANIA);
        sparePartRepository.save(sparePart);
    }

    public void createSparePartGermany(DTOSparePart dtoSparePart)
    {
        SparePart sparePart = convertSparePart.OneToModel(dtoSparePart);
        sparePart.setOrigin(Origin.GERMANY);
        sparePartRepository.save(sparePart);
    }

    public List<DTOSparePart> getAllSpareParts()
    {
        List<SparePart> sparePartList = sparePartRepository.findAll();

        List<DTOSparePart> dtoSparePartList = convertSparePart.ManyToDTO(sparePartList);

        return dtoSparePartList;
    }

    public List<DTOSparePart> getByName(String name)
    {
        List<SparePart> sparePartList = sparePartRepository.findByName(name);

        List<DTOSparePart> dtoSparePartList = convertSparePart.ManyToDTO(sparePartList);

        return dtoSparePartList;

    }

    public DTOSparePart getBySeries(String series)
    {
        SparePart sparePart = sparePartRepository.findBySeries(series);

        DTOSparePart dtoSparePart = convertSparePart.OneToDTO(sparePart);

        return dtoSparePart;
    }

    public List<DTOSparePart> getByOrigin(Origin origin)
    {
        List<SparePart> sparePartList = sparePartRepository.findByOrigin(origin);

        List<DTOSparePart> dtoSparePartList = convertSparePart.ManyToDTO(sparePartList);

        return dtoSparePartList;
    }

    public DTOSparePart getById(Long id)
    {
        SparePart sparePart = sparePartRepository.findFirstById(id);

        DTOSparePart dtoSparePart = convertSparePart.OneToDTO(sparePart);

        return dtoSparePart;
    }


    public void removeSparePart(Long id)
    {
        sparePartRepository.deleteById(id);
    }

    public void update(Long id, DTOSparePart dtoSparePart)
    {
        SparePart newSparePart = convertSparePart.OneToModel(dtoSparePart);

        SparePart oldSparePart = sparePartRepository.findFirstById(id);

        newSparePart.setId(oldSparePart.getId());

        sparePartRepository.save(newSparePart);
    }


}
