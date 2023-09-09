package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.TextileStatusDto;

import java.util.List;

public interface TextileStatusService {
    List<TextileStatusDto> getTextileStatuses();

    TextileStatusDto saveTextileStatus(TextileStatusDto textileStatus);

    TextileStatusDto findById(int id);
}
