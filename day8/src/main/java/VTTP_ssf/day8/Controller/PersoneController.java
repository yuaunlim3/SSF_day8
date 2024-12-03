package VTTP_ssf.day8.Controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import VTTP_ssf.day8.Model.Person;
import VTTP_ssf.day8.Repository.PersonRepo;
import VTTP_ssf.day8.Service.PersonService;
import jakarta.validation.Valid;

@Controller
@RequestMapping({ "/", "/index.html" })
public class PersoneController {
    @Autowired private PersonService personSrv;
    private final Logger logger = Logger.getLogger(PersoneController.class.getName());
    @GetMapping({ "/", "/index.html" })
    public String loginpage(Model model) {
        model.addAttribute("person", new Person());
        return "index";
    }

    @PostMapping({ "/", "/index.html" })
    public String Backloginpage(Model model) {
        model.addAttribute("person", new Person());
        return "index";
    }
    


    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("person") Person person, BindingResult binding, Model model){
        if(binding.hasErrors()){
            return "index";
        }
        personSrv.savePersonInfo(person);
        model.addAttribute("name", person.getFullName());
        return "redirect:/person/listing";
    }

    @GetMapping("/person/listing")
        public String getPerson(Model model){
            List<Person> personlist = personSrv.getInfo();

            logger.info("Personlist size %s\n".formatted(personlist.size()));

            model.addAttribute("personlist", personlist);
            return "personInfo";
        }
}
