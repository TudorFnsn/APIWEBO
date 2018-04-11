package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    //works
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOSparePart> getAll()
    {
        List<DTOSparePart> dtoSparePartList = sparePartService.getAllSpareParts();

        return dtoSparePartList;
    }


    //works
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTOSparePart dtoSparePart)
    {
        sparePartService.createSparePart(dtoSparePart);
    }

    //works
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTOSparePart getById(@PathVariable Long id)
    {
        DTOSparePart dtoSparePart = sparePartService.getById(id);

        return dtoSparePart;
    }


    //works
    @RequestMapping(value = "/getBySeries/{series}", method = RequestMethod.GET)
    public DTOSparePart getBySeries(@PathVariable String series)
    {
        DTOSparePart dtoSparePart = sparePartService.getBySeries(series);

        return dtoSparePart;
    }

    //works
    @RequestMapping(value = "/getByOrigin/{origin}", method = RequestMethod.GET)
    public List<DTOSparePart> getByOrigin(@PathVariable String origin)
    {
        List<DTOSparePart> dtoSparePartList = sparePartService.getByOrigin(origin);

        return dtoSparePartList;
    }


    //works
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        sparePartService.removeSparePart(id);
    }

    //works
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody DTOSparePart dtoSparePart)
    {
        sparePartService.update(id, dtoSparePart);
    }
}
