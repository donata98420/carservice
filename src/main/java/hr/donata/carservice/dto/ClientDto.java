package hr.donata.carservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDto {
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private String country;
    private Long number;
    private Long zipCode;
    private Long oib;
    private List<CarDto> carList;

}
