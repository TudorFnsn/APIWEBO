package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertVacation;
import ro.tudorfnsn.DataTransferObject.DTOVacation;
import ro.tudorfnsn.Model.Vacation;
import ro.tudorfnsn.Repository.VacationRepository;

import java.util.List;

@Service
public class VacationService
{
    private VacationRepository vacationRepository;
    private ConvertVacation convertVacation;

    @Autowired

    public VacationService(VacationRepository vacationRepository, ConvertVacation convertVacation)
    {
        this.vacationRepository = vacationRepository;
        this.convertVacation = convertVacation;
    }

    public void createVacation(DTOVacation dtoVacation)
    {
        Vacation vacation = convertVacation.OneToModel(dtoVacation);

        vacationRepository.save(vacation);
    }

    public List<DTOVacation> getAllVacations()
    {
        List<Vacation> vacationList = vacationRepository.findAll();

        List<DTOVacation> dtoVacationList = convertVacation.ManyToDTO(vacationList);

        return dtoVacationList;
    }
}
