package fon.bg.ac.rs.masterApp.servicesImpl;

import fon.bg.ac.rs.masterApp.dtos.InvoiceItemDto;
import fon.bg.ac.rs.masterApp.models.InvoiceItem;
import fon.bg.ac.rs.masterApp.repositories.InvoiceItemRepository;
import fon.bg.ac.rs.masterApp.services.InvoiceItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Override
    public InvoiceItemDto saveInvoiceItem(InvoiceItemDto invoiceItem) {


        InvoiceItem d = new InvoiceItem();
        BeanUtils.copyProperties(invoiceItem, d);
        InvoiceItem saved = invoiceItemRepository.save(d);
        invoiceItem.setId(saved.getId());

        return invoiceItem;
    }

    @Override
    public List<InvoiceItem> findByInvoiceSellingId(int id) {
        return invoiceItemRepository.findByInvoiceSellingId(id);
    }

    @Override
    public InvoiceItemDto findById(int id) {

        InvoiceItem find = invoiceItemRepository.findById(id).get();
        InvoiceItemDto d= new InvoiceItemDto();
        BeanUtils.copyProperties(find, d);

        return d;
    }

    @Override
    public void deleteById(int id) {

        invoiceItemRepository.deleteById(id);
    }



//    @Override
//    public void deleteByTextileId(int invoicesellingid, int textileid) {
//        invoiceItemRepository.deleteByTextileId(invoicesellingid, textileid);
//    }


    //    @Override
//    public List<LocationDto> findByCountryid(int id) {
//        return locationRepository.findByCountryid(id);
//    }
}
