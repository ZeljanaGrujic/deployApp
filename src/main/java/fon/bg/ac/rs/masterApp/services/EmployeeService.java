package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.models.Employee;
import fon.bg.ac.rs.masterApp.models.User;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee saveEmployee(Employee employee);

    Optional<Employee> findById(int id);

    void deleteById(int id);

    Employee findByUsername(String username);

    public void assignUsername(int id);

    List<Employee> findByEmployeeTypeId(int id);

    public User findUserForEmployee(int id);

    List<Employee> findByLocationId(int id);

    List<Employee> findByJobTitleId(int id);
}
