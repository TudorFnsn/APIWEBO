package ro.tudorfnsn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import ro.tudorfnsn.Enumerable.Department;
import ro.tudorfnsn.Model.Employee;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    Employee findFirstById(Long id);

    List<Employee> findByDepartment(Department department);

    List<Employee> findByPosition(String positon);

    Employee findFirstByName (String name);

    @Modifying
    @Transactional
    void deleteFirstById (Long id);
}
