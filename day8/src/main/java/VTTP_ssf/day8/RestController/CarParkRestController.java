package VTTP_ssf.day8.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VTTP_ssf.day8.Model.Carpark;
import VTTP_ssf.day8.Service.CPService;

@RestController
@RequestMapping("/api/carparks")
public class CarParkRestController {

    @Autowired CPService cpSvc;
    @GetMapping("")
    public ResponseEntity<List<Carpark>> getCarparks(){
        List<Carpark> carparks = cpSvc.getCarpark();
        return ResponseEntity.ok().body(carparks);
    }
}
