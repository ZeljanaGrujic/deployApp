package fon.bg.ac.rs.masterApp.controllers;

import fon.bg.ac.rs.masterApp.dtos.CountryDto;
import fon.bg.ac.rs.masterApp.dtos.EmployeeTypeDto;
import fon.bg.ac.rs.masterApp.dtos.JobTitleDto;
import fon.bg.ac.rs.masterApp.dtos.LocationDto;
import fon.bg.ac.rs.masterApp.models.*;
import fon.bg.ac.rs.masterApp.servicesImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    private EmployeeTypeServiceImpl employeeTypeServiceImpl;

    @Autowired
    private JobTitleServiceImpl jobTitleServiceImpl;

    @Autowired
    private LocationServiceImpl locationServiceImpl;

    @Autowired
    private CountryServiceImpl countryServiceImpl;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TextileServiceImpl textileService;

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeServiceImpl.getEmployees();
        List<EmployeeTypeDto> employeeTypes = employeeTypeServiceImpl.getEmployeeTypes();
        List<JobTitleDto> jobTitles = jobTitleServiceImpl.getJobTitles();
        List<LocationDto> locations = locationServiceImpl.getLocations();
        List<CountryDto> countries = countryServiceImpl.getCountries();

        System.out.println(employees);
        System.out.println(employeeTypes);
        System.out.println(jobTitles);
        System.out.println(locations);
        System.out.println(countries);

        if (employees.isEmpty()) {
            model.addAttribute("employees", null);
        } else {
            model.addAttribute("employees", employees);
        }
        model.addAttribute("employeeTypes", employeeTypes);
        model.addAttribute("jobTitles", jobTitles);
        model.addAttribute("locations", locations);
        model.addAttribute("countries", countries);

        //ovaj model saljem ka HTML stranici
        return "Employee";
    }

    @PostMapping("/employees/addNew")
    public String addBew(Employee employee) {
        try {

            Integer locationid = employee.getLocationid();
            System.out.println("Location id is: " + locationid);
            LocationDto locationDto = locationServiceImpl.findById((int) locationid);
            Integer countryID = locationDto.getCountryid();
            System.out.println("Country id from location: " + countryID);

            employee.setCountryid(countryID);

            if (employee.getPhoto().isEmpty() || employee.getPhoto() == "") {
                employee.setPhoto("default.jpg");
            }
            Employee saved = employeeServiceImpl.saveEmployee(employee);
            // System.out.println(employee.getLocation().getCountryid());
            System.out.println(saved.getId());
        } catch (Exception e) {
            System.out.println("Zaposleni nije uspesno sacuvan!" + e.getCause() + " " + e.getMessage() + " " + e.getLocalizedMessage());
            return "EmployeeSaveError";
        }
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Optional<Employee> findById(@RequestParam("id") Integer id) {
        Optional<Employee> employee = employeeServiceImpl.findById(id);
        System.out.println(employee);
        return employeeServiceImpl.findById(id);
    }

    @RequestMapping(value = "/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
//
//        System.out.println("Country id from Location: "+employee.getLocation().getCountryid());
//
//        CountryDto countryDto=countryServiceImpl.findById(employee.getLocation().getCountryid());
//        Country country= new Country();
//        BeanUtils.copyProperties(countryDto, country);
//
//        employee.setCountryid(country.getId());
//        employee.setCountry(country);


        Integer locationid = employee.getLocationid();
        LocationDto locationDto = locationServiceImpl.findById((int) locationid);
        Integer countryID = locationDto.getCountryid();
        System.out.println("Country id from location: " + countryID);

        employee.setCountryid(countryID);

        if (employee.getPhoto().isEmpty() || employee.getPhoto() == "") {
            employee.setPhoto("default.jpg");
        }
        Employee updated = employeeServiceImpl.saveEmployee(employee);
        System.out.println(updated.getId());
        return "redirect:/employees";
    }


    @RequestMapping(value = "/employees/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {

        try {
            if(textileService.findByEmployeeId(id).isEmpty()) {
                employeeServiceImpl.deleteById(id);
            }else{
                throw new Exception("Ne mozete izbrisati zaposlenog jer je zaduzen za neki proizvod!");
            }
        } catch (Exception e) {
            System.out.println("Ne mozete izbrisati podatke za ovog zaposlenog");
            return "EmployeeDeleteError";
        }
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/assignUsername/", params = {"id"}, method = RequestMethod.GET)
    public String assignUsername(int id) {

        try {

            if (employeeServiceImpl.findUserForEmployee(id) != null) {
                employeeServiceImpl.assignUsername(id);
                return "redirect:/employees";

            } else {
                throw new Exception("Ne mozete podesiti korisnicko ime za ovog zaposlenog jer nije registrovan!");
            }

        } catch (Exception e) {
            System.out.println("Neuspesno podesavanje username-a!");
            return "EmployeeUsernameSaveError";
        }

    }
}
