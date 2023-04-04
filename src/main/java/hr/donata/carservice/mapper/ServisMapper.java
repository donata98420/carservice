package hr.donata.carservice.mapper;

import hr.donata.carservice.dto.CarDto;

import hr.donata.carservice.dto.ClientDto;
import hr.donata.carservice.dto.ServisDto;
import hr.donata.carservice.entity.Car;

import hr.donata.carservice.entity.Client;
import hr.donata.carservice.entity.Servis;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ServisMapper {

    ServisMapper INSTANCE = Mappers.getMapper(ServisMapper.class);


    ServisDto servisToServisDto(Servis servis);
    Servis servisDtoToServis(ServisDto servisDto);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    default void updateServisFromServisDto(ServisDto servisDto, @MappingTarget Servis servis) {}



}
