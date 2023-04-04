package hr.donata.carservice.repository;

import hr.donata.carservice.entity.Car;
import hr.donata.carservice.entity.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Qualifier("client")
@Component
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  //  List<Car> findAll (Long oib);

    List<Car> findClientByIdIs (Long clientId);


}

