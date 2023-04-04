package hr.donata.carservice.entity;


import hr.donata.carservice.dto.CarType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor



public class Car {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_sequence")
    //@SequenceGenerator(name = "car_sequence", allocationSize = 10)
    //@Setter(AccessLevel.PRIVATE)

    private Long id;

    @Column(name = "year")
    private Long year;

    @Column(name ="carType")
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Column(name = "registrationMark")
    private String registrationMark;

    @Column(name = "color")
    private String color;

    @ManyToOne   // 1 klijent -> više auta, 1 auto za samo jednog klijenta (lista auta)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy="car", fetch = FetchType.EAGER)
    private List<Servis> servisList;



}
