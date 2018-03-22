package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTOVacation;
import ro.tudorfnsn.Model.Vacation;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertVacation implements ConverterInterface<Vacation, DTOVacation>
{
    @Override
    public DTOVacation OneToDTO(Vacation vacation)
    {
        DTOVacation dtoVacation = new DTOVacation();

        dtoVacation.setEmployee(vacation.getEmployee());
        dtoVacation.setLeave(vacation.getLeave());
        dtoVacation.setArrival(vacation.getArrival());
        dtoVacation.setMotive(vacation.getMotive());
        dtoVacation.setDescription(vacation.getDescription());

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

        vacation.setEmployee(dtoVacation.getEmployee());
        vacation.setLeave(dtoVacation.getLeave());
        vacation.setArrival(dtoVacation.getArrival());
        vacation.setMotive(dtoVacation.getMotive());
        vacation.setDescription(dtoVacation.getDescription());

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
