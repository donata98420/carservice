package hr.donata.carservice.controller;

import hr.donata.carservice.dto.CarDto;
import hr.donata.carservice.entity.Car;
import hr.donata.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Component
@Qualifier("car-controller")
@RestController
@RequestMapping("/car")
public class CarController {


    private final CarService carService;
    public CarController(CarService carService)
    {
        this.carService = carService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<CarDto> saveCar(@RequestBody CarDto carDto) {
        carService.create(carDto);
        return ResponseEntity.ok(carDto);
    }

    @PostMapping(path = "/update/{id}")
    private ResponseEntity<CarDto> updateCar(@RequestBody CarDto carDto, @PathVariable Long id) {
        carService.update(carDto, id);
        return ResponseEntity.ok(carDto);
    }


    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok("Car deleted!");
    }

    @GetMapping(path = "/getAll")
    private ResponseEntity<List<Car>> getAllCars() {
        List<Car> allCars = carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }

    @GetMapping(path = "/get/{id}")
    private ResponseEntity<Car> getById(@PathVariable Long id) {
        Optional<Car> optionalCar = carService.getCarById(id);
        if(optionalCar.isPresent()) {
            return ResponseEntity.ok(optionalCar.get());
        }
        throw new RuntimeException("This car does not exists in this database!");
    }





}
