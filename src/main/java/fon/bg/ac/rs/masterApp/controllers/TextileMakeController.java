package fon.bg.ac.rs.masterApp.controllers;

import fon.bg.ac.rs.masterApp.dtos.TextileMakeDto;
import fon.bg.ac.rs.masterApp.servicesImpl.TextileMakeServiceImpl;
import fon.bg.ac.rs.masterApp.servicesImpl.TextileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TextileMakeController {

    @Autowired
    private TextileMakeServiceImpl textileMakeServiceImpl;

    @Autowired
    private TextileServiceImpl textileService;

    @GetMapping("/textileMakes")
    public String getTextileMakes(Model model) {

        List<TextileMakeDto> textileMakes = textileMakeServiceImpl.getTextileMakes();
        System.out.println(textileMakes);
        model.addAttribute("textileMakes", textileMakes);
        if (textileMakes.isEmpty()) {
            model.addAttribute("textileMakes", null);
        } else {
            model.addAttribute("textileMakes", textileMakes);
        }
        //ovaj model saljem ka HTML stranici
        return "TextileMake";
    }

    @PostMapping("/textileMakes/addNew")
    public String addBew(TextileMakeDto textileMake) {
        try {
            TextileMakeDto savedTextileMake = textileMakeServiceImpl.saveTextileMake(textileMake);
            System.out.println(savedTextileMake.getId());
        }catch (Exception e){
            System.out.println("Marka nije uspesno sacuvana!");
            return "TextileMakeSaveError";
        }
        return "redirect:/textileMakes";
    }

    @RequestMapping(value = "/textileMakes/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public TextileMakeDto findById(@RequestParam("id") Integer id) {
        TextileMakeDto textileMake = textileMakeServiceImpl.findById(id);
        System.out.println(textileMake);
        return textileMakeServiceImpl.findById(id);
    }

    @RequestMapping(value = "/textileMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(TextileMakeDto textileMake) {
        TextileMakeDto updatedTextileMake = textileMakeServiceImpl.saveTextileMake(textileMake);
        System.out.println(updatedTextileMake.getId());
        return "redirect:/textileMakes";
    }


    @RequestMapping(value = "/textileMakes/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {

        try {
            if(textileService.findByTextleMakeId(id).isEmpty()) {
                textileMakeServiceImpl.deleteById(id);
            }else {
                throw new Exception("Ne mozete izbrisati marku jer postoje proizvodi sa ovim podacima!");
            }
        }catch (Exception e){
            System.out.println("Ne mozete izbrisati podatke za ovu marku");
            return "TextileMakeDeleteError";
        }
        return "redirect:/textileMakes";
    }
}
