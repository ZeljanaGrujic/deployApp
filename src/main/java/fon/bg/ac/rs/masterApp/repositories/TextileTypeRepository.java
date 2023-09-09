package fon.bg.ac.rs.masterApp.repositories;

import fon.bg.ac.rs.masterApp.models.TextileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextileTypeRepository extends JpaRepository<TextileType, Integer> {

}
