package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.DTONews;
import ro.tudorfnsn.Service.NewsService;

import java.util.Date;
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

    //works
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTONews> getAll()
    {
        List<DTONews> dtoNewsList = newsService.getAllNews();

        return dtoNewsList;
    }

    //works
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTONews dtoNews)
    {
        newsService.createNews(dtoNews);
    }

    //works
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTONews getById(@PathVariable Long id)
    {
        DTONews dtoNews = newsService.getById(id);

        return dtoNews;
    }

    //works
    @RequestMapping(value = "/getByTitle/{title}", method = RequestMethod.GET)
    public DTONews getByTitle(@PathVariable  String title)
    {
        DTONews dtoNews = newsService.getByTitle(title);

        return dtoNews;
    }

    //pending
    @RequestMapping(value = "/getByStartDate/{date}", method = RequestMethod.GET)
    public List<DTONews> getByStartDate(@PathVariable Date date)
    {
        List<DTONews> dtoNewsList = newsService.getByStartDate(date);

        return dtoNewsList;
    }



    //works
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        newsService.removeById(id);
    }

    //works
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody DTONews dtoNews)
    {
        newsService.update(id, dtoNews);
    }




}
