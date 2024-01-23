package bdbt_bada_project.SpringApplication.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "Czlonkowie")
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Czlonka")
    private Long memberId;
    @Column(name = "Imie")
    private String name;
    @Column(name = "Drugie_imie")
    private String secondname;
    @Column(name = "Nazwisko")
    private String lastname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Data_urodzenia")
    private Date birthDate;
    @Column(name = "Plec")
    private String sex;
    @Column(name = "PESEL")
    private Long PESEL;
    @Column(name = "Email")
    private String email;
    @Column(name = "Numer_telefonu")
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Data_zapisu")
    private Date signDate;
    @Column(name = "Czy_przedstawiciel")
    private String agent;

    @ManyToOne
    @JoinColumn(name = "ID_klubu")
    private Address club;

    @ManyToOne
    @JoinColumn(name = "ID_adresu")
    private Address address;

}
