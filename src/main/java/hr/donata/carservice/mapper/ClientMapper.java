package hr.donata.carservice.mapper;

import hr.donata.carservice.dto.CarDto;
import hr.donata.carservice.dto.ClientDto;
import hr.donata.carservice.entity.Car;
import hr.donata.carservice.entity.Client;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "carList", target = "carList", qualifiedByName = "toCarDtos")
    ClientDto clientToClientDto(Client client);

    Client clientDtoToClient(ClientDto clientDto);

    @Named("toCarDtos")
    default List<CarDto> toCarDtos(List<Car> cars) {
        if (cars == null) {
            return null;
        }

        List<CarDto> carDtos = new ArrayList<>(cars.size());
        for (Car car : cars) {
            carDtos.add(CarMapper.INSTANCE.carToCarDto(car));
        }
        return carDtos;
    }

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    default void updateClientFromClientDto(ClientDto clientDto, @MappingTarget Client client) {}


}








