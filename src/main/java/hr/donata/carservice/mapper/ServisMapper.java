package hr.donata.carservice.mapper;

import hr.donata.carservice.dto.ServisDto;
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

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

     void updateServisFromServisDto(ServisDto servisDto, @MappingTarget Servis servis);



}
