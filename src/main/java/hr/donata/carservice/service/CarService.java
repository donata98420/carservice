package hr.donata.carservice.service;

import hr.donata.carservice.dto.CarDto;
import hr.donata.carservice.entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public interface CarService {

    CarDto create(CarDto car);
    List<Car> getAllCars();
    void deleteCar(Long id);
    Optional<Car> getCarById(Long id);
    CarDto update(CarDto carDto, Long id);
    abstract void deleteCarService(Long id);
    //abstract void deleteCarService(Long id);
}
