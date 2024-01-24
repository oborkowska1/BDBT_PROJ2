package bdbt_bada_project.SpringApplication.Controller;

import bdbt_bada_project.SpringApplication.Entity.PostOffice;
import bdbt_bada_project.SpringApplication.Repository.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostOfficeController {
    @Autowired
    private PostOfficeRepository postOfficeRepository;

    @GetMapping("/postoffice")
    public String listpostoffice(Model model){
        List<PostOffice> postoffice = postOfficeRepository.findAll();
        model.addAttribute("postoffice",postoffice);

        return "postoffice";
    }
    @GetMapping("/postoffice/new")
    public String newPostoffice(Model model){
        model.addAttribute("PostOffice",new PostOffice());

        return "new_postoffice";
    }
   @GetMapping("/postoffice/delete/{id}")
    public String deletePostoffice(Model model, @PathVariable("id") Long id){
        postOfficeRepository.deleteById(id);

        return "redirect:/postoffice";
    }
    @PostMapping("/postoffice/save")
    public String savepostoffice(PostOffice postOffice){
        postOfficeRepository.save(postOffice);

        return "redirect:/postoffice";
    }

}

