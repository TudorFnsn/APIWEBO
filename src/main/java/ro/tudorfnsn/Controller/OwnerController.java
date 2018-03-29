package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOOwner> getAll()
    {
        List<DTOOwner> dtoOwnerList = ownerService.getAllOwners();

        return dtoOwnerList;
    }
}
