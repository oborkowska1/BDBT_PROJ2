package bdbt_bada_project.SpringApplication.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "Adresy")
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_adresu")
    private Long addressId;
    @Column(name = "Kraj")
    private String country;
    @Column(name = "Miasto")
    private String city;
    @Column(name = "Ulica")
    private String street;
    @Column(name = "Nr_budynku")
    private String buildingNumber;

    @ManyToOne
    @JoinColumn(name = "ID_poczty")
    private PostOffice post;

    @Override
    public String toString() {
        return country + " " + city + " " + street;
    }
}


