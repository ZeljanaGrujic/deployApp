package fon.bg.ac.rs.masterApp.controllers;

import fon.bg.ac.rs.masterApp.dtos.TextileModelDto;
import fon.bg.ac.rs.masterApp.servicesImpl.TextileModelServiceImpl;
import fon.bg.ac.rs.masterApp.servicesImpl.TextileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TextileModelController {

        @Autowired
    private TextileModelServiceImpl textileModelServiceImpl;

        @Autowired
        private TextileServiceImpl textileService;

    @GetMapping("/textileModels")
    public String getTextileTypes(Model model) {

        List<TextileModelDto> textileModels = textileModelServiceImpl.getTextileModels();
        System.out.println(textileModels);
        model.addAttribute("textileModels", textileModels);
        //ovaj model saljem ka HTML stranici
        if (textileModels.isEmpty()) {
            model.addAttribute("textileModels", null);
        } else {
            model.addAttribute("textileModels", textileModels);
        }

        return "TextileModel";
    }

    @PostMapping("/textileModels/addNew")
    public String addBew(TextileModelDto textileModel) {
        try {
            TextileModelDto savedTextileModel = textileModelServiceImpl.saveTextileModel(textileModel);
            System.out.println(savedTextileModel.getId());
        }catch (Exception e){
            System.out.println("Model nije uspesno sacuvan!");
            return "TextileModelSaveError";
        }
        return "redirect:/textileModels";
    }

    @RequestMapping(value = "/textileModels/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public TextileModelDto findById(@RequestParam("id") Integer id) {
        TextileModelDto textileModel = textileModelServiceImpl.findById(id);
        System.out.println(textileModel);
        return textileModelServiceImpl.findById(id);
    }

    @RequestMapping(value = "/textileModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(TextileModelDto textileModel) {
        TextileModelDto updatedTextileModel = textileModelServiceImpl.saveTextileModel(textileModel);
        System.out.println(updatedTextileModel.getId());
        return "redirect:/textileModels";
    }


    @RequestMapping(value = "/textileModels/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {

        try {
            if(textileService.findByTextileModelId(id).isEmpty()) {
                textileModelServiceImpl.deleteById(id);
            }else{
                throw new Exception("Ne mozete izbrisati model jer postoje proizvodi sa ovim podacima!");
            }
        }catch (Exception e){
            System.out.println("Ne mozete izbrisati podatke za ovaj model");
            return "TextileModelDeleteError";
        }
        return "redirect:/textileModels";
    }

}
