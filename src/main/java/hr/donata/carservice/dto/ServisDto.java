package hr.donata.carservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

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
