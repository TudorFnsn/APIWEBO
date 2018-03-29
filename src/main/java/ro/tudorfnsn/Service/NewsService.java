package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConvertNews;
import ro.tudorfnsn.DataTransferObject.DTONews;
import ro.tudorfnsn.Model.News;
import ro.tudorfnsn.Repository.NewsRepository;

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
}
