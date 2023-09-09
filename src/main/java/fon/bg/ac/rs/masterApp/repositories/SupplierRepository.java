package fon.bg.ac.rs.masterApp.repositories;

import fon.bg.ac.rs.masterApp.dtos.ClientDto;
import fon.bg.ac.rs.masterApp.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    List<Supplier> findByLocationId(int id);
}
