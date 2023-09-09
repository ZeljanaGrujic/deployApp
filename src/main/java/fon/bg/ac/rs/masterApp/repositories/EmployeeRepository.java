package fon.bg.ac.rs.masterApp.repositories;

import fon.bg.ac.rs.masterApp.models.Employee;
import fon.bg.ac.rs.masterApp.models.InvoiceSelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByUsername(String username);
    List<Employee> findByEmployeeTypeId(int id);
    List<Employee> findByLocationId(int id);
    List<Employee> findByJobTitleId(int id);
}
