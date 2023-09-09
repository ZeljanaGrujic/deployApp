package fon.bg.ac.rs.masterApp.repositories;

import fon.bg.ac.rs.masterApp.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
