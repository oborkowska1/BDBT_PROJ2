package bdbt_bada_project.SpringApplication.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "Kluby_wysokogorskie")
@NoArgsConstructor
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_klubu")
    private Long clubId;
    @Column(name = "Nazwa")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Data_zalozenia")
    private Date creationDate;
    @Column(name = "Numer_telefonu")
    private String phoneNumber;
    @Column(name = "Email")
    private String email;
    @Column(name = "Numer_rachunku_bankowego")
    private String bankAccountNumber;

    @ManyToOne
    @JoinColumn(name = "ID_adresu")
    private Address address;


}
