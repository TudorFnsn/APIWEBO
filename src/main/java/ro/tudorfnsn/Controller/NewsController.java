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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DTONews> getAll()
    {
        List<DTONews> dtoNewsList = newsService.getAllNews();

        return dtoNewsList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody DTONews dtoNews)
    {
        newsService.createNews(dtoNews);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DTONews getById(@PathVariable Long id)
    {
        DTONews dtoNews = newsService.getById(id);

        return dtoNews;
    }

    @RequestMapping(value = "/getByTitle/{title}", method = RequestMethod.GET)
    public DTONews getByTitle(@PathVariable  String title)
    {
        DTONews dtoNews = newsService.getByTitle(title);

        return dtoNews;
    }

    @RequestMapping(value = "/getByStartDate/{date}", method = RequestMethod.GET)
    public List<DTONews> getByStartDate(@PathVariable Date date)
    {
        List<DTONews> dtoNewsList = newsService.getByStartDate(date);

        return dtoNewsList;
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        newsService.removeById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody DTONews dtoNews)
    {
        newsService.update(id, dtoNews);
    }




}
