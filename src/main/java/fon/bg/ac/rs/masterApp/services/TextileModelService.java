package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.TextileModelDto;

import java.util.List;

public interface TextileModelService {
    List<TextileModelDto> getTextileModels();

    TextileModelDto saveTextileModel(TextileModelDto textileModel);

    TextileModelDto findById(int id);

    void deleteById(int id);
}
