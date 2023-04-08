package hr.donata.carservice.service;

import hr.donata.carservice.dto.ServisDto;
import hr.donata.carservice.entity.Servis;
import hr.donata.carservice.mapper.ServisMapper;
import hr.donata.carservice.repository.ServisRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServisServiceImpl implements ServisService {
    private final ServisRepository servisRepository;
    private final ServisMapper servisMapper;

    public ServisServiceImpl(ServisRepository servisRepository, ServisMapper servisMapper) {
        this.servisRepository = servisRepository;
        this.servisMapper = servisMapper;
    }

    @Override
    public ServisDto create(ServisDto servisDto) {
        Servis servis =  servisMapper.servisDtoToServis(servisDto);
        servisRepository.save(servis);
        return servisDto;
    }

    @Override
    public Optional<Servis> getServisByDate(LocalDateTime date) {
        return Optional.empty();
    }


    @Override
    public void deleteServis(Long id) {
        servisRepository.deleteById(id);
    }

    @Override
    public ServisDto update(ServisDto servisDto, Long id) {
        Optional<Servis> optionalServis = servisRepository.findById(id);

        if (optionalServis.isPresent()) {
            servisMapper.updateServisFromServisDto(servisDto, optionalServis.get());
            servisRepository.save(optionalServis.get());
        } else {
            throw new RuntimeException("This service does not exist anymore.");
        }

        return servisDto;
    }


    @Override
    public Optional<Servis> getServisById(Long id) {

        return servisRepository.findById(id);
    }

    @Override
    public List<Servis> getAllServis() {

        return servisRepository.findAll();
    }
}
