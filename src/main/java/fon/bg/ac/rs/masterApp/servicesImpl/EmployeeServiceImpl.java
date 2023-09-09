package fon.bg.ac.rs.masterApp.servicesImpl;

import fon.bg.ac.rs.masterApp.models.Employee;
import fon.bg.ac.rs.masterApp.models.User;
import fon.bg.ac.rs.masterApp.repositories.EmployeeRepository;
import fon.bg.ac.rs.masterApp.repositories.UserRepository;
import fon.bg.ac.rs.masterApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    public void assignUsername(int id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = userRepository.findByFirstnameAndLastname(
                employee.getFirstname(),
                employee.getLastname());
        employee.setUsername(user.getUsername());
        employeeRepository.save(employee);
    }

    public User findUserForEmployee(int id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = userRepository.findByFirstnameAndLastname(
                employee.getFirstname(),
                employee.getLastname());
        return user;
    }

    @Override
    public List<Employee> findByLocationId(int id) {
        List<Employee> all= employeeRepository.findByLocationId(id);
        return all;
    }

    @Override
    public List<Employee> findByJobTitleId(int id) {
        List<Employee> all= employeeRepository.findByJobTitleId(id);
        return all;
    }

    @Override
    public List<Employee> findByEmployeeTypeId(int id) {
        List<Employee> all= employeeRepository.findByEmployeeTypeId(id);

        return all;
    }
}
