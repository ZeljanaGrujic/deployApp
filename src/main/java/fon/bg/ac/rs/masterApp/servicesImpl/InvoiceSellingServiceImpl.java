package fon.bg.ac.rs.masterApp.servicesImpl;

import fon.bg.ac.rs.masterApp.dtos.InvoiceSellingDto;
import fon.bg.ac.rs.masterApp.dtos.LocationDto;
import fon.bg.ac.rs.masterApp.models.InvoiceSelling;
import fon.bg.ac.rs.masterApp.repositories.InvoiceSellingRepository;
import fon.bg.ac.rs.masterApp.services.InvoiceSellingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceSellingServiceImpl implements InvoiceSellingService {

    @Autowired
    private InvoiceSellingRepository invoiceSellingRepository;

    @Override
    public List<InvoiceSellingDto> getInvoicesSelling() {

        List<InvoiceSelling> all = invoiceSellingRepository.findAll();
        List<InvoiceSellingDto> dtos = all.stream()
                .map(d -> new InvoiceSellingDto(d.getId(),
                        d.getInvoiceDate(),
                        d.getInvoiceStatus(),
                        d.getInvoicestatusid(),
                        d.getClient(),
                        d.getClient().getId(),
                        d.getSpecialRemarks())).collect(Collectors.toList());

        return dtos;
    }

    @Override
    public InvoiceSellingDto saveInvoiceSelling(InvoiceSellingDto invoiceSelling) {

        InvoiceSelling d = new InvoiceSelling();
        BeanUtils.copyProperties(invoiceSelling, d);

        InvoiceSelling saved = invoiceSellingRepository.save(d);
        invoiceSelling.setId(saved.getId());

        return invoiceSelling;
    }

    @Override
    public InvoiceSellingDto findById(int id) {

        InvoiceSelling find = invoiceSellingRepository.findById(id).get();
        InvoiceSellingDto d = new InvoiceSellingDto();
        BeanUtils.copyProperties(find, d);

        return d;
    }

    @Override
    public List<InvoiceSellingDto> findByClientId(int id) {
        List<InvoiceSelling> all=invoiceSellingRepository.findByClientId(id);
        List<InvoiceSellingDto> dtos = all.stream()
                .map(d -> new InvoiceSellingDto(d.getId(),
                        d.getInvoiceDate(),
                        d.getInvoiceStatus(),
                        d.getInvoicestatusid(),
                        d.getClient(),
                        d.getClientid(),
                        d.getSpecialRemarks())).collect(Collectors.toList());
        return dtos;
    }
}
