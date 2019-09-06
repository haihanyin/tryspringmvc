package p.hh.trymvc.ter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

    @GetMapping("/greeting")
    @ResponseBody
    public String greeting(@RequestParam("exp") String exp) {
        if ("client".equals(exp)) {
            throw new TerException("client");
        } else if ("server".equals(exp)) {
            throw new TerException("server");
        }
        return "hello";
    }
}
