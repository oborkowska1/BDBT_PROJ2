package bdbt_bada_project.SpringApplication.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Poczty")
@NoArgsConstructor
@Getter
@Setter
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_poczty")
    private Long postId;
    @Column(name = "Kod_pocztowy")
    private String postCode;
    @Column(name = "Poczta")
    private String placepostoffice;


  @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
   private List<Address> addresses;


}
