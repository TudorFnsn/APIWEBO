package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertNews;
import ro.tudorfnsn.DataTransferObject.DTONews;
import ro.tudorfnsn.Model.News;
import ro.tudorfnsn.Repository.NewsRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NewsService
{
    private NewsRepository newsRepository;
    private ConvertNews convertNews;

    @Autowired

    public NewsService(NewsRepository newsRepository, ConvertNews convertNews)
    {
        this.newsRepository = newsRepository;
        this.convertNews = convertNews;
    }

    public void createNews(DTONews dtoNews)
    {
        News news = convertNews.OneToModel(dtoNews);

        newsRepository.save(news);
    }

    public List<DTONews> getAllNews()
    {
        List<News> newsList = newsRepository.findAll();

        List<DTONews> dtoNewsList = convertNews.ManyToDTO(newsList);

        return dtoNewsList;
    }

    public DTONews getByTitle(String title)
    {
        News news = newsRepository.findFirstByTitle(title);

        DTONews dtoNews = convertNews.OneToDTO(news);

        return dtoNews;
    }

    public List<DTONews> getByStartDate(Date date)
    {
        List<News> newsList = newsRepository.findByStartDate(date);

        List<DTONews> dtoNewsList = convertNews.ManyToDTO(newsList);

        return dtoNewsList;
    }

    public DTONews getById(Long id)
    {
        News news = newsRepository.findFirstById(id);

        DTONews dtoNews = convertNews.OneToDTO(news);

        return dtoNews;
    }

    public void removeById(Long id)
    {
        newsRepository.deleteFirstById(id);
    }

    public void update(Long id, DTONews dtoNews)
    {
        News freshNews = convertNews.OneToModel(dtoNews);

        News oldNews = newsRepository.findFirstById(id);

        freshNews.setId(oldNews.getId());

        newsRepository.save(freshNews);
    }

    public List<String> getAllNewsPictures()
    {
        List<News> newsList = newsRepository.findAll();

        List<DTONews> dtoNewsList = convertNews.ManyToDTO(newsList);

        List<String> listPictures = new ArrayList<>();

        for(DTONews dtoNews : dtoNewsList)
        {
            listPictures.add(dtoNews.getPicture());
        }

        return listPictures;
    }
}
