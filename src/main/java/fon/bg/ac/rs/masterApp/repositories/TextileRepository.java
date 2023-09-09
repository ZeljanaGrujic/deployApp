package fon.bg.ac.rs.masterApp.repositories;

import fon.bg.ac.rs.masterApp.models.Textile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TextileRepository extends JpaRepository<Textile, Integer> {

    List<Textile> findByPurpose(String purpose);

    List<Textile> findByTextleMakeId(int id);
    List<Textile> findByTextileModelId(int id);
    List<Textile> findByTextileStatusId(int id);

    List<Textile> findByTextileTypeId(int id);

    List<Textile> findByInChargeId(int id);

    @Query(
            value = "SELECT * FROM textile WHERE id NOT IN (SELECT textile_id FROM invoices_textile WHERE invoice_selling_id = ?1)",
            nativeQuery = true
    )
    Set<Textile> getNotInvoiceItems(Integer invoiceId);

}
