package fon.bg.ac.rs.masterApp.repositories;

import fon.bg.ac.rs.masterApp.models.InvoiceBuying;
import fon.bg.ac.rs.masterApp.models.InvoiceSelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceBuyingRepository extends JpaRepository<InvoiceBuying, Integer> {

    List<InvoiceBuying> findBySupplierId(int id);

}
