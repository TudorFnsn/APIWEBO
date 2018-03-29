package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tudorfnsn.DataTransferObject.DTOVacation;
import ro.tudorfnsn.Service.VacationService;

import java.util.List;

@RestController
@RequestMapping(value = "/vacation")
public class VacationController
{
    private VacationService vacationService;

    @Autowired

    public VacationController(VacationService vacationService)
    {
        this.vacationService = vacationService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOVacation> getAll()
    {
        List<DTOVacation> dtoVacationList = vacationService.getAllVacations();
        return dtoVacationList;
    }

}
