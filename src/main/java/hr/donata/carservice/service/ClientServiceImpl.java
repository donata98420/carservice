package hr.donata.carservice.service;

import hr.donata.carservice.dto.ClientDto;
import hr.donata.carservice.entity.Client;
import hr.donata.carservice.mapper.ClientMapper;
import hr.donata.carservice.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    //konstruktori
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDto create(ClientDto clientDto) {
        Client client =  clientMapper.clientDtoToClient(clientDto);
        clientRepository.save(client);
        return clientDto;
    }

    @Override
    public ClientDto update(ClientDto clientDto, Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        if(optionalClient.isPresent()) {
            clientMapper.updateClientFromClientDto(clientDto, optionalClient.get());
            clientRepository.save(optionalClient.get());
        } else {
            throw new RuntimeException("Sorry, this client does not exist anymore.");
        }

        return clientDto;
    }

    @Override
    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Long id) {

        clientRepository.deleteById(id);
    }

    @Override
    public Optional<Client> getClientById(Long id) {

        return clientRepository.findById(id);
    }




}
