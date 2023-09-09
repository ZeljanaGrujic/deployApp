package fon.bg.ac.rs.masterApp.dtos;

import fon.bg.ac.rs.masterApp.models.InvoiceStatus;
import fon.bg.ac.rs.masterApp.models.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class InvoiceBuyingDto {


    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;


    private InvoiceStatus invoiceStatus;
    private Integer invoicestatusid;


    private Supplier supplier;
    private Integer supplierid;


    private String specialRemarks;
//    private int totalCost;

//    Set<Textile> items= new HashSet<>();

//    private Textile textile;
//    private Integer textileid;


}
