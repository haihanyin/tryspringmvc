package p.hh.trymvc.tma.controller.fill;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BallController {

    @GetMapping("/ball/{id}")
    public Ball getBall(@ModelAttribute Ball ball) {
        return ball;
    }
}
