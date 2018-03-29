package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.tudorfnsn.DataTransferObject.DTONews;
import ro.tudorfnsn.Service.NewsService;

import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class NewsController
{
    private NewsService newsService;

    @Autowired

    public NewsController(NewsService newsService)
    {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTONews> getAll()
    {
        List<DTONews> dtoNewsList = newsService.getAllNews();

        return dtoNewsList;
    }


}
