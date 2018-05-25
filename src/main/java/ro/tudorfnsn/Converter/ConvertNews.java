package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.DTONews;
import ro.tudorfnsn.Model.News;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertNews implements ConverterInterface<News, DTONews>
{
    @Override
    public DTONews OneToDTO(News news)
    {
        DTONews dtoNews = new DTONews();

        dtoNews.setId(news.getId());
        dtoNews.setTitle(news.getTitle());
        dtoNews.setPicture(news.getPicture());
        dtoNews.setStartDate(news.getStartDate());
        dtoNews.setEndDate(news.getEndDate());


        return dtoNews;
    }

    @Override
    public List<DTONews> ManyToDTO(List<News> news)
    {
        List<DTONews> dtoNewsList = new ArrayList<>();

        for(News newss : news)
            dtoNewsList.add(OneToDTO(newss));

        return dtoNewsList;
    }

    @Override
    public News OneToModel(DTONews dtoNews)
    {
        News news = new News();

        news.setTitle(dtoNews.getTitle());
        news.setPicture(dtoNews.getPicture());
        news.setStartDate(dtoNews.getStartDate());
        news.setEndDate(dtoNews.getEndDate());

        return news;
    }

    @Override
    public List<News> ManyToModel(List<DTONews> dtoNews)
    {
        List<News> newsList = new ArrayList<>();

        for(DTONews dtoNewss : dtoNews)
            newsList.add(OneToModel(dtoNewss));

        return newsList;
    }
}
