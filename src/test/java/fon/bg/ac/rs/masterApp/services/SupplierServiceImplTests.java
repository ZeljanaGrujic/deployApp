package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.SupplierDto;
import fon.bg.ac.rs.masterApp.models.Location;
import fon.bg.ac.rs.masterApp.models.Supplier;
import fon.bg.ac.rs.masterApp.repositories.SupplierRepository;
import fon.bg.ac.rs.masterApp.servicesImpl.SupplierServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class SupplierServiceImplTests {

    @Autowired
    private SupplierServiceImpl service;
    @MockBean
    private SupplierRepository repository;
    @Test
    void getSuppliers() {

        Supplier newObj = new Supplier();
        newObj.setFullName("Dobavljac1");
        newObj.setCompanyName("Kompanija1");
        newObj.setPhone("Telefon1");
        newObj.setEmail("Zaposleni1@gmail.com");
        newObj.setLocation(new Location());


        SupplierDto newObjDto = new SupplierDto();
        newObjDto.setFullName("Dobavljac1");
        newObjDto.setCompanyName("Kompanija1");
        newObjDto.setPhone("Telefon1");
        newObjDto.setEmail("Zaposleni1@gmail.com");
        newObjDto.setLocation(new Location());

        List<Supplier> items = new ArrayList<>();
        items.add(newObj);
        when(repository.findAll()).thenReturn(items);

        List<SupplierDto> expectedItems = Arrays.asList(newObjDto);
        List<SupplierDto> foundItems = service.getSuppliers();

        assertEquals(expectedItems, foundItems);
    }

    @Test
    void saveSupplier() {

        Supplier newObj = new Supplier();
        newObj.setFullName("Dobavljac1");
        newObj.setCompanyName("Kompanija1");
        newObj.setPhone("Telefon1");
        newObj.setEmail("Zaposleni1@gmail.com");

        SupplierDto newObjDto = new SupplierDto();
        newObjDto.setFullName("Dobavljac1");
        newObjDto.setCompanyName("Kompanija1");
        newObjDto.setPhone("Telefon1");
        newObjDto.setEmail("Zaposleni1@gmail.com");

        when(repository.save(newObj)).thenReturn(newObj);

        SupplierDto expected = newObjDto;
        //i sada mogu samo da testiram biznis logiku servisa, i da se fokusiram na to a ne i na rad repozitorijuma
        //apstrahovala sam sve ono sto je ispod jer sam to vec istestirala u repositori testovima
        SupplierDto found = service.saveSupplier(newObjDto);

        assertEquals(expected, found);
    }

    @Test
    void findById() {
        Supplier newObj = new Supplier();
        newObj.setFullName("Dobavljac1");
        newObj.setCompanyName("Kompanija1");
        newObj.setPhone("Telefon1");
        newObj.setEmail("Zaposleni1@gmail.com");

        SupplierDto newObjDto = new SupplierDto();
        newObjDto.setFullName("Dobavljac1");
        newObjDto.setCompanyName("Kompanija1");
        newObjDto.setPhone("Telefon1");
        newObjDto.setEmail("Zaposleni1@gmail.com");

        when(repository.findById(1)).thenReturn(Optional.ofNullable(newObj));

        SupplierDto expected = newObjDto;
        SupplierDto found = service.findById(1);

        assertEquals(expected, found);
    }

    @Test
    void deleteById() {
        Supplier newObj = new Supplier();
        newObj.setId(1);
        newObj.setFullName("Dobavljac1");
        newObj.setCompanyName("Kompanija1");
        newObj.setPhone("Telefon1");
        newObj.setEmail("Zaposleni1@gmail.com");
        newObj.setLocation(new Location());

        SupplierDto newObjDto = new SupplierDto();
        newObjDto.setId(1);
        newObjDto.setFullName("Dobavljac1");
        newObjDto.setCompanyName("Kompanija1");
        newObjDto.setPhone("Telefon1");
        newObjDto.setEmail("Zaposleni1@gmail.com");
        newObjDto.setLocation(new Location());

        when(repository.findById(newObj.getId())).thenReturn(Optional.ofNullable(newObj));
        service.deleteById(newObj.getId());
        verify(repository, times(1)).deleteById(newObj.getId());
    }
}