package hr.donata.carservice.service;

import hr.donata.carservice.dto.ClientDto;
import hr.donata.carservice.entity.Car;
import hr.donata.carservice.entity.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {

    ClientDto update(ClientDto clientDto, Long id);
    void deleteClient(Long id);
    ClientDto create(ClientDto client);
    Optional<Client> getClientById(Long id);
    List<Client> getAllClients();

}
