package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.ClientDto;
import fon.bg.ac.rs.masterApp.models.Client;

import java.util.List;

public interface ClientService {
    List<ClientDto> getClients();

    ClientDto saveClient(ClientDto client);

    ClientDto findById(int id);

    void deleteById(int id);
    List<ClientDto> findByLocationId(int id);
}
