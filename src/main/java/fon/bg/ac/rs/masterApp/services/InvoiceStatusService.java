package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.InvoiceStatusDto;

import java.util.List;

public interface InvoiceStatusService {
    List<InvoiceStatusDto> getInvoiceStatuses();

    InvoiceStatusDto saveInvoiceStatus(InvoiceStatusDto invoiceStatus);

    InvoiceStatusDto findById(int id);
}
