package ro.tudorfnsn.web;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.DataTransferObject.*;
import ro.tudorfnsn.Model.Machine;

@Component
public class WebpageGenerator
{

    public void init()
    {
        String apiUrl = "http://localhost:8080";
        //new GeneratorHTMLCRUD(DTOMachine.class, apiUrl, "machine").create();
//        new GeneratorHTMLCRUD(DTOBill.class, apiUrl, "bill").create();
//        new GeneratorHTMLCRUD(DTODaySchedule.class, apiUrl, "schedule").create();
//        new GeneratorHTMLCRUD(DTOEmployee.class, apiUrl, "employee").create();
//        new GeneratorHTMLCRUD(DTOMachine.class, apiUrl, "news").create();
//        new GeneratorHTMLCRUD(DTOOwner.class, apiUrl, "owner").create();
//        new GeneratorHTMLCRUD(DTOSparePart.class, apiUrl, "sparepart").create();
//        new GeneratorHTMLCRUD(DTOTask.class, apiUrl, "task").create();
//        new GeneratorHTMLCRUD(DTOVacation.class, apiUrl, "vacation").create();
        System.out.println("YOLOOOOOOO");
    }
}
