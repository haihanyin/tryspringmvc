package p.hh.trymvc.tlr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BookController {

    @GetMapping("/greeting")
    public String greeting(HttpSession session) {
        return "greeting";
    }
}
