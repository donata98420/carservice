package hr.donata.carservice.mapper;

import hr.donata.carservice.dto.CarDto;
import hr.donata.carservice.dto.ServisDto;
import hr.donata.carservice.entity.Car;
import hr.donata.carservice.entity.Servis;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    @Mapping(source = "car.id", target = "carType")
    CarDto carToCarDto(Car car);

    List<ServisDto> servisToServisDtos(List<Servis> serviss);


    @Named("toServisDtos")
    default List<ServisDto> toServisDtos(List<Servis> serviss) {
        if (serviss == null) {
            return null;
        }

        List<ServisDto> servisDtos = new ArrayList<>(serviss.size());
        for (Servis servis : serviss) {
            servisDtos.add(ServisMapper.INSTANCE.servisToServisDto(servis));
        }
        return servisDtos;
    }

    default void updateCarFromCarDto(CarDto carDto, @MappingTarget Car car) {}
    default void updateServisFromServisDto(ServisDto servisDto, @MappingTarget Servis servis) {}

    @Mapping(source = "carId", target = "car.id")
    Servis servisDtoToServis(ServisDto servisDto);

    @Mapping(source = "clientId", target = "client.id")
    Car carDtoToCar(CarDto carDto);




}
