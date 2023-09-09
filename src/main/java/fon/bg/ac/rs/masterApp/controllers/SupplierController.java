package fon.bg.ac.rs.masterApp.controllers;

import fon.bg.ac.rs.masterApp.dtos.LocationDto;
import fon.bg.ac.rs.masterApp.dtos.SupplierDto;
import fon.bg.ac.rs.masterApp.servicesImpl.InvoiceBuyingServiceImpl;
import fon.bg.ac.rs.masterApp.servicesImpl.LocationServiceImpl;
import fon.bg.ac.rs.masterApp.servicesImpl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    private SupplierServiceImpl supplierServiceImpl;

    @Autowired
    private LocationServiceImpl locationServiceImpl;

    @Autowired
    private InvoiceBuyingServiceImpl invoiceBuyingService;


    @GetMapping("/suppliers")
    public String getSuppliers(Model model) {

        List<LocationDto> locations = locationServiceImpl.getLocations();
        List<SupplierDto> suppliers=supplierServiceImpl.getSuppliers();
        System.out.println(locations);
        System.out.println(suppliers);
        model.addAttribute("locations", locations);
        if(suppliers.isEmpty()){
            model.addAttribute("suppliers", null);
        }else {
            model.addAttribute("suppliers", suppliers);
        }
        //ovaj model saljem ka HTML stranici
        return "Supplier";
    }

    @PostMapping("/suppliers/addNew")
    public String addBew(SupplierDto supplier) {
        SupplierDto saved = supplierServiceImpl.saveSupplier(supplier);
        System.out.println(saved.getId());
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public SupplierDto findById(@RequestParam("id") Integer id) {
        SupplierDto supplier = supplierServiceImpl.findById(id);
        System.out.println(supplier);
        return supplierServiceImpl.findById(id);
    }

    @RequestMapping(value = "/suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(SupplierDto supplier) {
        SupplierDto updated = supplierServiceImpl.saveSupplier(supplier);
        System.out.println(updated.getId());
        return "redirect:/suppliers";
    }


    @RequestMapping(value = "/suppliers/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {

        try {
            if(invoiceBuyingService.findBySupplierId(id).isEmpty()) {
                supplierServiceImpl.deleteById(id);
            }else {
                throw new Exception("Ne mozete izbrisati ovog dobavljaca jer postoje fakture za njega");
            }
        }catch (Exception e){
            System.out.println("Ne mozete izbrisati podatke za ovog dobavljaca");
            return "SupplierDeleteError";
        }
        return "redirect:/suppliers";
    }

}
