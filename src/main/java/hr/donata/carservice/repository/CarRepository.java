package hr.donata.carservice.repository;

import hr.donata.carservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByColor(String color);

}
