package hr.donata.carservice.controller;

import hr.donata.carservice.dto.ServisDto;
import hr.donata.carservice.entity.Servis;
import hr.donata.carservice.service.ServisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servis")
public class ServisController {
    private final ServisService servisService;

    public ServisController(ServisService servisService) {
        this.servisService = servisService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<ServisDto> saveServis(@RequestBody ServisDto servisDto) {
        servisService.create(servisDto);
        return ResponseEntity.ok(servisDto);
    }

    @PostMapping(path = "/update/{id}")
    private ResponseEntity<ServisDto> updateServis(@RequestBody ServisDto servisDto, @PathVariable Long id) {
        servisService.update(servisDto, id);
        return ResponseEntity.ok(servisDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteServis(@PathVariable Long id) {
        servisService.deleteServis(id);
        return ResponseEntity.ok("Your service has been deleted.");
    }

    @GetMapping(path = "/getAll")
    private ResponseEntity<List<Servis>> getAllServis() {
        List<Servis> allServis = servisService.getAllServis();
        return ResponseEntity.ok(allServis);
    }

    @GetMapping(path = "/get/{id}")
    private ResponseEntity<Servis> getById(@PathVariable Long id) {
        Optional<Servis> optionalServis = servisService.getServisById(id);
        if(optionalServis.isPresent()) {
            return ResponseEntity.ok(optionalServis.get());
        }
        throw new RuntimeException("This service does not exist in this database!");
    }

    @GetMapping(path = "/get/servisDate/{dateTime}")
    private ResponseEntity<List<Servis>> getAllServisByDateTime(@RequestParam("dateTime") String dateTime) {
        List<Servis> allServis = servisService.getAllServisByDateTime(dateTime);
        return ResponseEntity.ok(allServis);
    }



}
