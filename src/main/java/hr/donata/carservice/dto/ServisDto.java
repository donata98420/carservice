package hr.donata.carservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServisDto {

    private LocalDateTime dateOfService;
    private String workerFirstName;
    private String workerLastName;
    private String workerDescription;
    private float price;
    private boolean isPaid;
    private Long carId;

}
