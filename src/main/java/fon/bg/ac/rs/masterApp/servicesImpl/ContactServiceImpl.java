package fon.bg.ac.rs.masterApp.servicesImpl;

import fon.bg.ac.rs.masterApp.dtos.ContactDto;
import fon.bg.ac.rs.masterApp.models.Contact;
import fon.bg.ac.rs.masterApp.repositories.ContactRepository;
import fon.bg.ac.rs.masterApp.services.ContactService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {


    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ContactDto> getContacts() {

        List<Contact> all = contactRepository.findAll();
        List<ContactDto> dtos = all.stream()
                .map(d -> new ContactDto(d.getId(),
                        d.getFirstname(),
                        d.getLastname(),
                        d.getPhone(),
                        d.getEmail(),
                        d.getRemarks())).collect(Collectors.toList());

        return dtos;
    }

    @Override
    public ContactDto saveContact(ContactDto contact) {

        Contact d = new Contact();
        BeanUtils.copyProperties(contact, d);

        Contact saved = contactRepository.save(d);
        contact.setId(saved.getId());

        return contact;
    }

    @Override
    public ContactDto findById(int id) {


        Contact find=contactRepository.findById(id).get();
        ContactDto d= new ContactDto();
        BeanUtils.copyProperties(find, d);

        return d;
    }

    @Override
    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }
}
