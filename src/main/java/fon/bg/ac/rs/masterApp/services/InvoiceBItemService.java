package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.InvoiceBItemDto;
import fon.bg.ac.rs.masterApp.models.InvoiceBItem;

import java.util.List;

public interface InvoiceBItemService {
    InvoiceBItemDto saveInvoiceItem(InvoiceBItemDto invoiceItem);

    List<InvoiceBItem> findByInvoiceBuyingId(int id);

    InvoiceBItemDto findById(int id);
    public void deleteById(int id);

//    void deleteByTextileId(int invoicesellingid, int textileid);

    //    List<LocationDto> findByCountryid(int id);
}
