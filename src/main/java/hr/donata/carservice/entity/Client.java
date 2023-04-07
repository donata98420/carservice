package hr.donata.carservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_sequence")
    @SequenceGenerator(name = "client_sequence", allocationSize = 1)
    private Long id;
    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "oib")
    private Long oib;

   @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private Long number;

    @Column(name = "zipcode")
    private Long zipCode;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy="client", fetch = FetchType.EAGER)
    private List<Car> carList;

}
