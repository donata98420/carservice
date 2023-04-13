package hr.donata.carservice.service;

import hr.donata.carservice.dto.CarDto;
import hr.donata.carservice.entity.Car;
import java.util.List;
import java.util.Optional;

public interface CarService {

    CarDto create(CarDto car);
    List<Car> getAllCars();
    void deleteCar(Long id);
    Optional<Car> getCarById(Long id);
    CarDto update(CarDto carDto, Long id);

    List<CarDto> findAllByColor(String color);
}
