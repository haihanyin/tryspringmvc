package p.hh.trymvc.tca.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice(assignableTypes = CarController.class)
public class CarControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        Object binderTarget = webDataBinder.getTarget();
        if (Car.class.equals(binderTarget.getClass())) {
            Car car = (Car)binderTarget;
            car.setName("proxy_" + car.getName());
        }
    }
}
