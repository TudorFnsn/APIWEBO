package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOVacation;
import ro.tudorfnsn.Model.Vacation;
import ro.tudorfnsn.Repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertVacation implements ConverterInterface<Vacation, DTOVacation>
{
    private EmployeeRepository employeeRepository;

    public ConvertVacation(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DTOVacation OneToDTO(Vacation vacation)
    {
        DTOVacation dtoVacation = new DTOVacation();

        dtoVacation.setId(vacation.getId());
        dtoVacation.setEmployeeId(vacation.getEmployee().getId());
        //dtoVacation.setEmployeeId(vacation.getEmployee().getId());
        dtoVacation.setLeave(vacation.getLeave());
        dtoVacation.setArrival(vacation.getArrival());
        dtoVacation.setMotive(vacation.getMotive());
        dtoVacation.setDescriptions(vacation.getDescriptions());

        return dtoVacation;
    }

    @Override
    public List<DTOVacation> ManyToDTO(List<Vacation> vacations)
    {
        List<DTOVacation> dtoVacationList = new ArrayList<>();

        for(Vacation vacation : vacations)
            dtoVacationList.add(OneToDTO(vacation));

        return dtoVacationList;
    }

    @Override
    public Vacation OneToModel(DTOVacation dtoVacation)
    {
        Vacation vacation = new Vacation();

        vacation.setEmployee(employeeRepository.findFirstById(dtoVacation.getEmployeeId()));
        //vacation.setEmployee(employeeRepository.findFirstById(dtoVacation.getEmployeeId()));
        vacation.setLeave(dtoVacation.getLeave());
        vacation.setArrival(dtoVacation.getArrival());
        vacation.setMotive(dtoVacation.getMotive());
        vacation.setDescriptions(dtoVacation.getDescriptions());

        return vacation;

    }

    @Override
    public List<Vacation> ManyToModel(List<DTOVacation> dtoVacations)
    {
        List<Vacation> vacationList = new ArrayList<>();

        for(DTOVacation dtoVacation : dtoVacations)
            vacationList.add(OneToModel(dtoVacation));

        return vacationList;
    }
}
