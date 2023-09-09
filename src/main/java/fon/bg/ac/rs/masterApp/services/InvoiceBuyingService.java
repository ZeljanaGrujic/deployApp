package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.InvoiceBuyingDto;

import java.util.List;

public interface InvoiceBuyingService {
    List<InvoiceBuyingDto> getInvoicesBuying();

    InvoiceBuyingDto saveInvoiceBuying(InvoiceBuyingDto invoiceBuying);

    InvoiceBuyingDto findById(int id);

    public List<InvoiceBuyingDto> findBySupplierId(int id);
}
