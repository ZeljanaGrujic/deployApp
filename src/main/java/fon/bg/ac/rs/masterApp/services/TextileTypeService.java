package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.TextileTypeDto;

import java.util.List;

public interface TextileTypeService {
    List<TextileTypeDto> getTextileTypes();

    TextileTypeDto saveTextileType(TextileTypeDto textileType);

    TextileTypeDto findById(int id);

    void deleteById(int id);
}
