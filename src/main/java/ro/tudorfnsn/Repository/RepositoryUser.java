package ro.tudorfnsn.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ro.tudorfnsn.Model.UserEntity;

import javax.transaction.Transactional;

public interface RepositoryUser extends JpaRepository<UserEntity, Long>
{
    UserEntity findByUsername(String email);
    UserEntity findById(Long id);


    @Modifying
    @Transactional
    void deleteById(Long id);

}
