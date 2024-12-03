package VTTP_ssf.day8.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import VTTP_ssf.day8.Model.Carpark;
import VTTP_ssf.day8.Service.CPService;
@Controller
@RequestMapping ()
public class CarParkController {
    @Autowired
    private CPService CPService;

    @PostMapping("/carpark")
    public String getCarpark(Model model){
        List<Carpark> carparkList = CPService.getCarpark();
        model.addAttribute("carparkList", carparkList);
        return "carparkInfo";
    }
}
