package p.hh.trymvc.tlr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class BookController {

    @ModelAttribute
    public void doSomething() {
        System.out.println("doSomething");
    }

    @GetMapping("/greeting")
    public String greeting(HttpSession session) {
        return "greeting";
    }
}
