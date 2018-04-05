package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Model.News;

import java.util.Date;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long>
{
    News findFirstById (Long id);

    News findFirstByTitle (String title);

    List<News> findByStartDate (Date date);

    void deleteFirstById (Long id);
}
