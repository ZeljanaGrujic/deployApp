package fon.bg.ac.rs.masterApp.dtos;

import fon.bg.ac.rs.masterApp.models.InvoiceBuying;
import fon.bg.ac.rs.masterApp.models.Textile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceBItemDto {


    private Integer id;

    private Integer quantity;
    private Integer totalCost;


    private InvoiceBuying invoiceBuying;
    private Integer invoicebuyingid;


    private Textile textile;
    private Integer textileid;
}
