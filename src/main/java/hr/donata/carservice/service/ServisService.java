package hr.donata.carservice.service;

import hr.donata.carservice.dto.ServisDto;
import hr.donata.carservice.entity.Servis;

import java.util.List;
import java.util.Optional;

public interface ServisService {
    void deleteServis(Long id);
    ServisDto create(ServisDto servis);
    Optional<Servis> getServisById(Long id);
    List<Servis> getAllServis();
    ServisDto update(ServisDto servisDto, Long id);
}
