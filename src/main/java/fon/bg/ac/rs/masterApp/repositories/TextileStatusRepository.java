package fon.bg.ac.rs.masterApp.repositories;

import fon.bg.ac.rs.masterApp.models.TextileStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextileStatusRepository extends JpaRepository<TextileStatus, Integer> {
}
