package hr.donata.carservice.service;

import hr.donata.carservice.dto.CarDto;
import hr.donata.carservice.entity.Car;
import hr.donata.carservice.mapper.CarMapper;
import hr.donata.carservice.repository.CarRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public CarDto create(CarDto carDto) {
        Car car =  carMapper.carDtoToCar(carDto);
        carRepository.save(car);
        return carDto;
    }

    @Override
    public CarDto update(CarDto carDto, Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if(optionalCar.isPresent()) {
            carMapper.updateCarFromCarDto(carDto, optionalCar.get());
            carRepository.save(optionalCar.get());
        } else {
            throw new RuntimeException("This car does not exist in database.");
        }
        return carDto;
    }

    @Override
    public Optional<Car> findByColor(String color) {
        return carRepository.findByColor(color);
    }

    @Override
    public List<Car> getAllCars() {

        return carRepository.findAll();
    }

    @Override
    public void deleteCar(Long id) {

        carRepository.deleteById(id);
    }

    @Override
    public Optional<Car> getCarById(Long id) {

        return carRepository.findById(id);
    }


}
