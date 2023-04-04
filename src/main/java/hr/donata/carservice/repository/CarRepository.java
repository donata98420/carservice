package hr.donata.carservice.repository;

import hr.donata.carservice.entity.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Qualifier(value = "car")
@Component
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByClientId(Long clientId);
    List<Car> findCarByCarType(Long carId);



}
