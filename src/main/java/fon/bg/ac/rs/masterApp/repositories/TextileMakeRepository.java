package fon.bg.ac.rs.masterApp.repositories;

import fon.bg.ac.rs.masterApp.models.TextileMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextileMakeRepository extends JpaRepository<TextileMake, Integer> {
}
