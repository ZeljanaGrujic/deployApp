package fon.bg.ac.rs.masterApp.repositories;

import fon.bg.ac.rs.masterApp.models.InvoiceSelling;
import fon.bg.ac.rs.masterApp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceSellingRepository extends JpaRepository<InvoiceSelling, Integer> {

    List<InvoiceSelling> findByClientId(int id);

}
