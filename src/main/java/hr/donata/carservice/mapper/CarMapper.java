package hr.donata.carservice.mapper;

import hr.donata.carservice.dto.CarDto;
import hr.donata.carservice.dto.ServisDto;
import hr.donata.carservice.entity.Car;
import hr.donata.carservice.entity.Servis;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    @Mapping(source = "car.id", target = "carType")
    CarDto carToCarDto(Car car);

     void updateCarFromCarDto(CarDto carDto, @MappingTarget Car car);
     void updateServisFromServisDto(ServisDto servisDto, @MappingTarget Servis servis);

    @Mapping(source = "carId", target = "car.id")
    Servis servisDtoToServis(ServisDto servisDto);

    @Mapping(source = "clientId", target = "client.id")
    Car carDtoToCar(CarDto carDto);

}
