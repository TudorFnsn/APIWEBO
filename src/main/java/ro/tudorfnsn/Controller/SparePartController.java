package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tudorfnsn.DataTransferObject.DTOSparePart;
import ro.tudorfnsn.Service.SparePartService;

import java.util.List;

@RestController
@RequestMapping(value = "/sparepart")
public class SparePartController
{
    private SparePartService sparePartService;

    @Autowired

    public SparePartController(SparePartService sparePartService)
    {
        this.sparePartService = sparePartService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOSparePart> getAll()
    {
        List<DTOSparePart> dtoSparePartList = sparePartService.getAllSpareParts();

        return dtoSparePartList;
    }
}
