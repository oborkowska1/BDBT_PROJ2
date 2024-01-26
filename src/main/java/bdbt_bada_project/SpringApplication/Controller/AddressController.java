package bdbt_bada_project.SpringApplication.Controller;

import bdbt_bada_project.SpringApplication.Entity.Address;
import bdbt_bada_project.SpringApplication.Entity.Club;
import bdbt_bada_project.SpringApplication.Entity.PostOffice;
import bdbt_bada_project.SpringApplication.Repository.AdressRepository;
import bdbt_bada_project.SpringApplication.Repository.ClubRepository;
import bdbt_bada_project.SpringApplication.Repository.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private AdressRepository addressRepository;
    @Autowired
    private PostOfficeRepository postofficeRepository;
     @GetMapping("/address")
    public String listAddress(Model model){
       List<Address> address = addressRepository.findAll();
       model.addAttribute("address",address);

        return "address";
    }
    @GetMapping("/address/new")
    public String newAddress(Model model){
        model.addAttribute("address",new Address());
        List<PostOffice> postOffices = postofficeRepository.findAll();
        model.addAttribute("postOffices",postOffices);

        return "new_address";
    }
    @GetMapping("/address/delete/{id}")
    public String deleteAddress(Model model, @PathVariable("id") Long id){
        addressRepository.deleteById(id);

        return "redirect:/address";
    }
    @PostMapping("/address/save")
    public String saveAddress(Address address){
       addressRepository.save(address);

        return "redirect:/address";
    }
}

