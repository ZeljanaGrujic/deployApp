package fon.bg.ac.rs.masterApp.dtos;

import fon.bg.ac.rs.masterApp.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class InvoiceSellingDto {


    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;


    private InvoiceStatus invoiceStatus;
    private Integer invoicestatusid;


    private Client client;
    private Integer clientid;

    private String specialRemarks;
//    private int totalCost;


//    private List<InvoiceItem> invoiceItems;
//    Set<Textile> items = new HashSet<>();

//    @Override
//    public String toString() {
//        return "InvoiceSelling{" +
//                "id=" + id +
//                ", invoiceDate=" + invoiceDate +
//                ", invoiceStatus=" + invoiceStatus +
//                ", invoicestatusid=" + invoicestatusid +
//                ", client=" + client +
//                ", clientid=" + clientid +
//                ", specialRemarks='" + specialRemarks + '\'' +
//                '}';
//    }

}
