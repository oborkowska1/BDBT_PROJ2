package bdbt_bada_project.SpringApplication.Controller;

import bdbt_bada_project.SpringApplication.Entity.Address;
import bdbt_bada_project.SpringApplication.Entity.Club;
import bdbt_bada_project.SpringApplication.Repository.AdressRepository;
import bdbt_bada_project.SpringApplication.Repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private AdressRepository addressRepository;

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<Club> clubs = clubRepository.findAll();
        model.addAttribute("clubs", clubs);
        return "clubs";
    }

    @GetMapping("/clubs/new")
    public String newClub(Model model) {
        model.addAttribute("club", new Club());
        List<Address> addresses = addressRepository.findAll();
        model.addAttribute("addresses", addresses);
        return "new_club";
    }

    @GetMapping("/clubs/delete/{id}")
    public String deleteClub(Model model, @PathVariable("id") Long id) {
        clubRepository.deleteById(id);
        return "redirect:/clubs";
    }

    @PostMapping("/clubs/new")
    public String saveClub(Club club) {
        Address selectedAddress = addressRepository.findById(club.getAddress().getAddressId()).orElse(null);
        club.setAddress(selectedAddress);
        clubRepository.save(club);
        return "redirect:/clubs";
    }
}
