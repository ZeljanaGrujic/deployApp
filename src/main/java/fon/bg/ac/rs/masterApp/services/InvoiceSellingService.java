package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.InvoiceSellingDto;

import java.util.List;

public interface InvoiceSellingService {
    List<InvoiceSellingDto> getInvoicesSelling();

    InvoiceSellingDto saveInvoiceSelling(InvoiceSellingDto invoiceSelling);

    InvoiceSellingDto findById(int id);

    List<InvoiceSellingDto> findByClientId(int id);
}
