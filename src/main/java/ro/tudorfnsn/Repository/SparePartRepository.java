package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Model.SparePart;

import java.util.List;

public interface SparePartRepository extends JpaRepository<SparePart, Long>
{
    SparePart findFirstById (Long id);
    List<SparePart> findByName (String name);
    SparePart findBySeries (String series);

    List<SparePart> findByOrigin (String origin);

    SparePart deleteById (Long id);
}
