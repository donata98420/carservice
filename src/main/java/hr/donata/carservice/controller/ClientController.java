package hr.donata.carservice.controller;

import hr.donata.carservice.entity.Client;
import hr.donata.carservice.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hr.donata.carservice.dto.ClientDto;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<String> saveClient(@RequestBody ClientDto clientDto) {
        clientService.create(clientDto);
        return ResponseEntity.ok("Your client is created.");
    }

    @PostMapping(path = "/update/{id}")
    private ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto, @PathVariable Long id) {
        clientService.update(clientDto, id);
        return ResponseEntity.ok(clientDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Your client has been deleted.");
    }

    @GetMapping(path = "/getAll")
    private ResponseEntity<List<Client>> getClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    private ResponseEntity<Client> getById(@PathVariable Long id) {
        Optional<Client> optionalClient = clientService.getClientById(id);
        if(optionalClient.isPresent()) {
            return ResponseEntity.ok(optionalClient.get());
        }
        throw new RuntimeException("Client does not exists in this database.");
    }

    @GetMapping(path = "/getAllByCountry")
    private ResponseEntity<List<Client>> getAllClientsByCountry(@RequestParam("country") String country) {
        List<Client> clients = clientService.getAllClientsByCountry(country);
        return ResponseEntity.ok(clients);
    }

}
