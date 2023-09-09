package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.ContactDto;

import java.util.List;

public interface ContactService {
    List<ContactDto> getContacts();

    ContactDto saveContact(ContactDto contact);

    ContactDto findById(int id);

    void deleteById(int id);
}
