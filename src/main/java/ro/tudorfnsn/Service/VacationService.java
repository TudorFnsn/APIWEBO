package ro.tudorfnsn.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertVacation;
import ro.tudorfnsn.DataTransferObject.DTOVacation;
import ro.tudorfnsn.Enumerable.MotiveOfAbsence;
import ro.tudorfnsn.Model.Employee;
import ro.tudorfnsn.Model.Vacation;
import ro.tudorfnsn.Repository.VacationRepository;

import java.util.Date;
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

//    public List<DTOVacation> getByEmployee(Employee employee)
//    {
//        List<Vacation> vacationList = vacationRepository.findByEmployee(employee);
//
//        List<DTOVacation> dtoVacationList = convertVacation.ManyToDTO(vacationList);
//
//        return dtoVacationList;
//    }

    public List<DTOVacation> getByMotive(MotiveOfAbsence motiveOfAbsence)
    {
        List<Vacation> vacationList = vacationRepository.findByMotive(motiveOfAbsence);

        List<DTOVacation> dtoVacationList = convertVacation.ManyToDTO(vacationList);

        return dtoVacationList;

    }

    public List<DTOVacation> getByLeave(Date date)
    {
        List<Vacation> vacationList = vacationRepository.findByLeave(date);

        List<DTOVacation> dtoVacationList = convertVacation.ManyToDTO(vacationList);

        return dtoVacationList;
    }

    public void removeVacation(Long id)
    {
        vacationRepository.deleteFirstById(id);
    }

    public void update(Long id, DTOVacation dtoVacation)
    {
        Vacation newVacation = convertVacation.OneToModel(dtoVacation);

        Vacation oldVacation = vacationRepository.findFirstById(id);

        newVacation.setId(oldVacation.getId());

        vacationRepository.save(newVacation);
    }

    public List<DTOVacation> getByEmployee(Employee employee)
    {
        List<Vacation> vacationList = vacationRepository.findByEmployee(employee);

        List<DTOVacation> dtoVacationList = convertVacation.ManyToDTO(vacationList);

        return dtoVacationList;
    }


}
