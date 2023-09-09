package fon.bg.ac.rs.masterApp.controllers;

import fon.bg.ac.rs.masterApp.dtos.InvoiceStatusDto;
import fon.bg.ac.rs.masterApp.servicesImpl.InvoiceStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusServiceImpl invoiceStatusServiceImpl;

    @GetMapping("/invoiceStatuses")
    public String getInvoiceStatus(Model model) {

        List<InvoiceStatusDto> invoiceStatuses = invoiceStatusServiceImpl.getInvoiceStatuses();
        System.out.println(invoiceStatuses);
        model.addAttribute("invoiceStatuses", invoiceStatuses);
        if(invoiceStatuses.isEmpty()){
            model.addAttribute("invoiceStatuses", null);
        }else {
            model.addAttribute("invoiceStatuses", invoiceStatuses);
        }
        //ovaj model saljem ka HTML stranici
        return "InvoiceStatus";
    }
    @PostMapping("/invoiceStatuses/addNew")
    public String addBew(InvoiceStatusDto invoiceStatus) {
        InvoiceStatusDto savedinvoiceStatuses = invoiceStatusServiceImpl.saveInvoiceStatus(invoiceStatus);
        System.out.println(invoiceStatus.getId());
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value = "/invoiceStatuses/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public InvoiceStatusDto findById(@RequestParam("id") Integer id) {
        InvoiceStatusDto invoiceStatus = invoiceStatusServiceImpl.findById(id);
        System.out.println(invoiceStatus);
        return invoiceStatusServiceImpl.findById(id);
    }
}
