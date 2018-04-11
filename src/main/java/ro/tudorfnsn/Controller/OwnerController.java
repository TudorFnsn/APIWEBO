package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTOOwner;
import ro.tudorfnsn.Service.OwnerService;

import java.util.List;

@RestController
@RequestMapping(value = "/owner")
public class OwnerController
{
    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService)
    {
        this.ownerService = ownerService;
    }

    //works
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOOwner> getAll()
    {
        List<DTOOwner> dtoOwnerList = ownerService.getAllOwners();

        return dtoOwnerList;
    }

    //works
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTOOwner dtoOwner)
    {
        ownerService.createOwner(dtoOwner);
    }

    //works
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTOOwner getById(@PathVariable Long id)
    {
        DTOOwner dtoOwner = ownerService.getById(id);

        return dtoOwner;
    }

    //works
    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public DTOOwner getByName(@PathVariable String name)
    {
        DTOOwner dtoOwner = ownerService.getByName(name);

        return dtoOwner;
    }

    //works
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        ownerService.deleteById(id);
    }




    //works
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody DTOOwner dtoOwner)
    {
        ownerService.update(id, dtoOwner);
    }
}
