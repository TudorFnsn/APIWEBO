package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTOVacation;
import ro.tudorfnsn.Enumerable.MotiveOfAbsence;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Service.VacationService;

import java.util.Date;
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

    //works
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTOVacation> getAll()
    {
        List<DTOVacation> dtoVacationList = vacationService.getAllVacations();
        return dtoVacationList;
    }

    //works
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTOVacation dtoVacation)
    {
        vacationService.createVacation(dtoVacation);
    }

    //works -- aici nu ii prea bine cu FINDFIRST pentru ca un employee poate avea mai multe vacations
    //ii rezolvat!!!
//    @RequestMapping(value = "/getByEmployee/{employee}", method = RequestMethod.GET)
//    public List<DTOVacation> getByEmployee(@PathVariable Employee employee)
//    {
//        List<DTOVacation> dtoVacationList = vacationService.getByEmployee(employee);
//
//        return dtoVacationList;
//    }

    //works
    @RequestMapping(value = "/getByMotive/{motiveOfAbsence}", method = RequestMethod.GET)
    public List<DTOVacation> getByMotive(@PathVariable MotiveOfAbsence motiveOfAbsence)
    {
        List<DTOVacation> dtoVacationList = vacationService.getByMotive(motiveOfAbsence);

        return dtoVacationList;
    }

    @RequestMapping(value = "/getByLeave/{leave}", method = RequestMethod.GET)
    public List<DTOVacation> getByLeave(@PathVariable Date leave)
    {
        List<DTOVacation> dtoVacationList = vacationService.getByLeave(leave);

        return dtoVacationList;
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        vacationService.removeVacation(id);
    }

    //works
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody DTOVacation dtoVacation)
    {
        vacationService.update(id, dtoVacation);
    }

    @RequestMapping(value = "/getByEmployee/{employee}", method = RequestMethod.GET)
    public List<DTOVacation> getByEmployee(@PathVariable Employee employee)
    {
        List<DTOVacation> dtoVacationList =vacationService.getByEmployee(employee);

        return dtoVacationList;
    }


}
