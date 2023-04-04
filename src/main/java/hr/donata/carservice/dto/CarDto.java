package hr.donata.carservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private String description;
    private Long year;
    private String carType;
    private String registrationMark;
    private String color;
    private Long clientId;
    private List<ServisDto> servisList;

}
