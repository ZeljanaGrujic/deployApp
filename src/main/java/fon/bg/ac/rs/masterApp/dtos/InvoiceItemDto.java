package fon.bg.ac.rs.masterApp.dtos;

import fon.bg.ac.rs.masterApp.models.InvoiceSelling;
import fon.bg.ac.rs.masterApp.models.Textile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemDto {


    private Integer id;

    private Integer quantity;
    private Integer totalCost;


    private InvoiceSelling invoiceSelling;
    private Integer invoicesellingid;


    private Textile textile;
    private Integer textileid;
}
