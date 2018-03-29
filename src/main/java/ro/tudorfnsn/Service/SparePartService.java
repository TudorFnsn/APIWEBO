package ro.tudorfnsn.Service;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertSparePart;
import ro.tudorfnsn.DataTransferObject.DTOSparePart;
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

    public List<DTOSparePart> getAllSpareParts()
    {
        List<SparePart> sparePartList = sparePartRepository.findAll();

        List<DTOSparePart> dtoSparePartList = convertSparePart.ManyToDTO(sparePartList);

        return dtoSparePartList;
    }
}
