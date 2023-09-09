package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.InvoiceItemDto;
import fon.bg.ac.rs.masterApp.models.InvoiceItem;

import java.util.List;

public interface InvoiceItemService {
    InvoiceItemDto saveInvoiceItem(InvoiceItemDto invoiceItem);

    List<InvoiceItem> findByInvoiceSellingId(int id);

    InvoiceItemDto findById(int id);
    public void deleteById(int id);

//    void deleteByTextileId(int invoicesellingid, int textileid);

    //    List<LocationDto> findByCountryid(int id);
}
