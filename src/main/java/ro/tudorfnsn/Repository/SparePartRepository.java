package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ro.tudorfnsn.Enumerable.Origin;
import ro.tudorfnsn.Model.SparePart;

import javax.transaction.Transactional;
import java.util.List;

public interface SparePartRepository extends JpaRepository<SparePart, Long>
{
    List<SparePart> findByIdIn(List<Long> ids);
    SparePart findFirstById (Long id);
    List<SparePart> findByName (String name);
    SparePart findBySeries (String series);

    List<SparePart> findByOrigin (Origin origin);

    @Modifying
    @Transactional
    void deleteById (Long id);
}
