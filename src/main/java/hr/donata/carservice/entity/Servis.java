package hr.donata.carservice.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@Entity
@Table(name = "servis")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Servis {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servis_sequence")
    @SequenceGenerator(name = "servis_sequence", allocationSize = 1)
    @Setter(AccessLevel.PRIVATE)

    private Long id;

    @Column(name = "dateOfService")
    private LocalDateTime dateOfService;
    @Column(name = "workerFirstName")
    private String workerFirstName;
    @Column(name = "workerLastName")
    private String workerLastName;
    @Column(name = "workerDescription")
    private String workerDescription;
    @Column(name = "price")
    private float price;
    @Column(name = "isPaid")
    private boolean isPaid;

    @ManyToOne //
    @JoinColumn(name = "car_id")
    private Car car;

}
