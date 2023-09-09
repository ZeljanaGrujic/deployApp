package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.TextileDto;
import fon.bg.ac.rs.masterApp.models.Textile;

import java.util.List;

public interface TextileService {
    List<TextileDto> getTextiles();

    TextileDto saveTextile(TextileDto textile);

    TextileDto findById(int id);

    void deleteById(int id);
    List<TextileDto> findByPurpose(String purpose);

    List<TextileDto> findByTextleMakeId(int id);
    List<TextileDto> findByTextileModelId(int id);
    List<TextileDto> findByTextileStatusId(int id);

    List<TextileDto> findByTextileTypeId(int id);

    List<TextileDto> findByEmployeeId(int id);
}
