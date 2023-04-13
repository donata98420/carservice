package hr.donata.carservice.repository;

import hr.donata.carservice.entity.Car;
import hr.donata.carservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByCountry(String country);


}

