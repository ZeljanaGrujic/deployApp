package fon.bg.ac.rs.masterApp.controllers;

import fon.bg.ac.rs.masterApp.dtos.JobTitleDto;
import fon.bg.ac.rs.masterApp.servicesImpl.EmployeeServiceImpl;
import fon.bg.ac.rs.masterApp.servicesImpl.JobTitleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobTitleController {


    @Autowired
    private JobTitleServiceImpl jobTitleServiceImpl;

    @Autowired
    private EmployeeServiceImpl employeeService;


    @GetMapping("/jobTitles")
    public String getJobTitles(Model model) {

        List<JobTitleDto> jobTitles = jobTitleServiceImpl.getJobTitles();
        if(jobTitles.isEmpty()){
            model.addAttribute("jobTitles", null);
        }else {
            System.out.println(jobTitles);
            model.addAttribute("jobTitles", jobTitles);
        }
        //ovaj model saljem ka HTML stranici
        return "JobTitle";
    }

    @PostMapping("/jobTitles/addNew")
    public String addBew(JobTitleDto jobTitle) {
        try {
            JobTitleDto savedType = jobTitleServiceImpl.saveJobTitle(jobTitle);
            System.out.println(savedType.getId());
        }catch (Exception e){
            System.out.println("Naziv/opis radnog mesta nisu uspesno sacuvani!");
            return "JobTitleSaveError";
        }
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/jobTitles/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public JobTitleDto findById(@RequestParam("id") Integer id) {
        JobTitleDto type = jobTitleServiceImpl.findById(id);
        System.out.println(type);
        return jobTitleServiceImpl.findById(id);
    }

    @RequestMapping(value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitleDto jobTitle) {
        JobTitleDto updatedType = jobTitleServiceImpl.saveJobTitle(jobTitle);
        System.out.println(updatedType.getId());
        return "redirect:/jobTitles";
    }


    @RequestMapping(value = "/jobTitles/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {

        try {
            if(employeeService.findByJobTitleId(id).isEmpty()) {
                jobTitleServiceImpl.deleteById(id);
            }else {
                throw new Exception("Ne mozete izbrisati ovaj naziv/opis radnog mesta jer postoji zaposleni sa ovim podacima");
            }
        }catch (Exception e){
            System.out.println("Ne mozete izbrisati podatke za ovaj naziv/opis radnog mesta");
            return "JobTitleDeleteError";
        }
        return "redirect:/jobTitles";
    }


}
