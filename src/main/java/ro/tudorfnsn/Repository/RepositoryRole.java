package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tudorfnsn.Model.RoleEntity;


public interface RepositoryRole extends JpaRepository<RoleEntity, Long>
{

}
