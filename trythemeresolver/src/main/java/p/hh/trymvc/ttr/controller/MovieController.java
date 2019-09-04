package p.hh.trymvc.ttr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    @GetMapping("/greeting")
    public String greeting() {
        return "greeting";
    }
}
