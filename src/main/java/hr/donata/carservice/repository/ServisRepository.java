package hr.donata.carservice.repository;

import hr.donata.carservice.entity.Servis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ServisRepository extends JpaRepository<Servis, Long> {
    Optional<Servis> getByDateOfService(LocalDateTime dateOfService);

    //List<Servis> findAllByDateOfService (Long servisId);


}
