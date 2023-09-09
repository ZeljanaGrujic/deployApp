package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.TextileMakeDto;

import java.util.List;

public interface TextileMakeService {
    List<TextileMakeDto> getTextileMakes();

    TextileMakeDto saveTextileMake(TextileMakeDto textileMake);

    TextileMakeDto findById(int id);

    void deleteById(int id);
}
