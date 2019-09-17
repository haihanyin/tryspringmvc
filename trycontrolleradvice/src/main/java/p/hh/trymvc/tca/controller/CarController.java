package p.hh.trymvc.tca.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @PostMapping("/car")
    public Car addCar(@RequestBody Car car) throws Exception {
        return car;
    }
}
