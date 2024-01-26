package bdbt_bada_project.SpringApplication.Controller;

import bdbt_bada_project.SpringApplication.Entity.Address;
import bdbt_bada_project.SpringApplication.Entity.PostOffice;
import bdbt_bada_project.SpringApplication.Repository.AdressRepository;
import bdbt_bada_project.SpringApplication.Repository.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AddressUserController {
@Autowired
private AdressRepository addressRepository;
@Autowired
private PostOfficeRepository postofficeRepository;
@GetMapping("/main_user")
public String listmain_user(Model model){
    List<Address> address = addressRepository.findAll();
    model.addAttribute("address",address);

            return "main_user";
        }

        @GetMapping("/main_user/delete/{id}")
        public String deletemainuser(Model model, @PathVariable("id") Long id){
            addressRepository.deleteById(id);

            return "redirect:/main_user";
        }

    }

